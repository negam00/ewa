package nl.hva.web.workshops.restaurant.rest;

import nl.hva.web.workshops.restaurant.model.Restaurant;
import nl.hva.web.workshops.restaurant.rest.model.ClientError;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hva.web.workshops.restaurant.service.impl.RepositoryServiceImpl;
import nl.hva.web.workshops.restaurant.service.RepositoryService;


/**
 * The flash card REST resource
 * 
 * @author Wouter, Artjom, Corniels
 */
@Path("restaurants")
public class RestaurantResource {
    
    /** a reference to the repository service */
    private RepositoryService service;
    
    public RestaurantResource() {
        service = RepositoryServiceImpl.getInstance();
    }
    
    /**
     * Get all flash cards
     * @return a JSON representation of a list of cards
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<nl.hva.web.workshops.restaurant.model.Restaurant> getAllCards() {
        return service.getAllRestaurants();
    }
    
    /**
     * Getting a specific flash card
     * @param id
     * @return 
     */
    @GET
    @Path("/{restaurantId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlashCard(@PathParam("restaurantId") int id) {

        nl.hva.web.workshops.restaurant.model.Restaurant fc = service.getRestaurantfromId(id);

        String message = "{ Error 404! Resource not found for id ";
        String aftermessage = "}";

        if (fc == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    status(Response.Status.NOT_FOUND)
                    .entity(message + id + aftermessage)
                    .build();

        } else {
            return Response.status(Response.Status.OK).entity(fc).build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurant createCustomer(Restaurant restaurant) {
        return service.addRestaurant(restaurant);
    }

    @DELETE
    @Path("{id}")
    public boolean deleteOrderById(@PathParam("id") int id) {
        return service.deleteRestaurant(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRestaurant(@PathParam("id") int id, Restaurant updateRestaurant) {
        return service.updateRestaurant(id, updateRestaurant);

    }


}
