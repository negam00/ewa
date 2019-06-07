package nl.hva.web.workshops.restaurant.rest.model;

import nl.hva.web.workshops.restaurant.model.Attendeekoppel;
import nl.hva.web.workshops.restaurant.model.User;
import nl.hva.web.workshops.restaurant.service.RepositoryService;
import nl.hva.web.workshops.restaurant.service.impl.RepositoryServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("attendeekoppels")
public class AttendeekoppelResource {

    private RepositoryService service;

    public AttendeekoppelResource() {
        service = RepositoryServiceImpl.getInstance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Attendeekoppel createKoppel(Attendeekoppel attendeekoppel) {
        return service.addKoppel(attendeekoppel);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<nl.hva.web.workshops.restaurant.model.Attendeekoppel> getAllKoppels() {
        return service.getAllKoppels();
    }

    @GET
    @Path("/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<nl.hva.web.workshops.restaurant.model.User> getListKoppels(@PathParam("eventId") int id) {
        return service.getListKoppels(id);
    }

//    @GET
//    @Path("/order/{eid}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getOrder(@PathParam("eid") int eid) {
//
//        nl.hva.web.workshops.restaurant.model.Attendeekoppel fc = service.getOrderfromId(eid);
//
//    }

    @DELETE
    @Path("{id}")
    public boolean deleteAttendeeId(@PathParam("id") int id) {
        return service.deleteAttendee(id);
    }

    @PUT
    @Path("{uid}/{eid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAttendee(@PathParam("uid") int uid, @PathParam("eid") int eid, Attendeekoppel koppel) {
        return service.updateOrder(uid, eid, koppel);

    }

}
