package nl.hva.web.workshops.restaurant.rest.model;

import nl.hva.web.workshops.restaurant.jwt.JWTUtils;
import nl.hva.web.workshops.restaurant.model.User;
import nl.hva.web.workshops.restaurant.service.RepositoryService;
import nl.hva.web.workshops.restaurant.service.impl.RepositoryServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;


@Path("users")
public class UserResource {

    private RepositoryService service;

    public UserResource() {
        service = RepositoryServiceImpl.getInstance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(User us, @Context UriInfo uri) {
        String login = us.getEmail();
        String password = us.getPassword();
        try {

            // Authenticate the user using the credentials provided
            // Note that we are using a hardcoded user and password
            // for the sake of simplicity

            if(!service.checkPassword(login,password)) {
                throw new IllegalAccessException("Not authorized!");
            }

            // Issue a token for the user
            String token = issueToken(login, uri);

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (IllegalAccessException e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login, UriInfo uri) {
        Key key = JWTUtils.getKey();

        // Could have more than one role, but now it is just one
        String roles = service.getRoles(login);

        String jwtToken = Jwts.builder()
                .setSubject(login)
                .claim("roles",roles)
                .setIssuer(uri.getPath())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+15*60*1000)) // 15 minutes
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();

        return jwtToken;
    }


    //Creates user
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return service.addUser(user);
    }

    //Get user list
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Temporary function to get users NOT JWT FRIENDLY
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean checkUser(@PathParam("email") String email) {

        return service.getUserfromEmail(email);
        }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRestaurant(@PathParam("id") int id, User user) {
        return service.updateUser(id, user);

    }

    }


