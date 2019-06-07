package nl.hva.web.workshops.restaurant.rest.model;

import nl.hva.web.workshops.restaurant.jwt.filter.JwtTokenMandatory;
import nl.hva.web.workshops.restaurant.model.Event;
import nl.hva.web.workshops.restaurant.service.RepositoryService;
import nl.hva.web.workshops.restaurant.service.impl.RepositoryServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("events")
public class EventResource {
    private RepositoryService service;

    public EventResource() {
        service = RepositoryServiceImpl.getInstance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Event createEvent(Event event) {
        return service.addEvent(event);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @JwtTokenMandatory(permissions = "admin")
    public List<nl.hva.web.workshops.restaurant.model.Event> getAllCards() {
        return service.getAllEvents();
    }

    @GET
    @Path("/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public int getHighestEvent() {
        return service.getLatestEvent();
    }

    @GET
    @Path("/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlashCard(@PathParam("eventId") int id) {

        nl.hva.web.workshops.restaurant.model.Event fc = service.getEventfromId(id);

        if(fc == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("resource not found for id " + id)).build();
        } else {
            return Response.status(Response.Status.OK).entity(fc).build();
        }
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPermittedEvents(@PathParam("userId") int id) {

        List<nl.hva.web.workshops.restaurant.model.Event> fc = service.getEventsfromId(id);

        if(fc == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("resource not found for id " + id)).build();
        } else {
            return Response.status(Response.Status.OK).entity(fc).build();
        }
    }
}
