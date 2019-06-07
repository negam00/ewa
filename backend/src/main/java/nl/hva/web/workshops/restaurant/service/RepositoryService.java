package nl.hva.web.workshops.restaurant.service;

import java.util.List;

import nl.hva.web.workshops.restaurant.model.Attendeekoppel;
import nl.hva.web.workshops.restaurant.model.Event;
import nl.hva.web.workshops.restaurant.model.Restaurant;
import nl.hva.web.workshops.restaurant.model.User;

import javax.ws.rs.core.Response;

/**
 * An interface containing utility methods to manage flash card data
 *
 * @author Wouter, Artjom, Corniels
 */
public interface RepositoryService {

    /**
     * Getting all flashcards
     *
     * @return
     */
    List<Restaurant> getAllRestaurants();
    List<Event> getAllEvents();
    List<User> getAllUsers();

    /**
     * Getting a specific flash card
     *
     * @param
     * @return
     */
    Restaurant getRestaurantfromId(int restaurantId);
    Event getEventfromId(int eventId);
    List<Event> getEventsfromId(int UID);
    User getUserfromId(int userId);



    Restaurant addRestaurant(Restaurant restaurant);
    Event addEvent(Event evt);
    User addUser(User user);
    Attendeekoppel addKoppel(Attendeekoppel attendeekoppel);
    List<Attendeekoppel> getAllKoppels();
    List getListKoppels(int IDU);
//    Attendeekoppel getOrderfromId(int eid);
    Boolean getUserfromEmail(String email);
    boolean deleteRestaurant(int id);
    boolean deleteAttendee(int id);

    Response updateRestaurant(int id, Restaurant updateRestaurant);
    Response updateOrder(int uid, int eid, Attendeekoppel koppel);

    boolean checkPassword(String email, String password);
    String getRoles(String login);
    int getLatestEvent();

    Response updateUser(int id, User user);
}
