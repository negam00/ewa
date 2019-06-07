package nl.hva.web.workshops.restaurant.service.impl;

import java.util.*;

import nl.hva.web.workshops.restaurant.model.Attendeekoppel;
import nl.hva.web.workshops.restaurant.model.Event;
import nl.hva.web.workshops.restaurant.model.Restaurant;
import nl.hva.web.workshops.restaurant.model.User;
import nl.hva.web.workshops.restaurant.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added
 * during class loading.
 *
 * @author Wouter, Artjom, Corniels
 */
public class RepositoryServiceImpl implements RepositoryService {


    private EntityManagerFactory entityManagerFactory;

    // A singleton reference
    private static RepositoryServiceImpl instance;

    // An instance of the service is created and during class initialisation
    static {
        try{
            instance = new RepositoryServiceImpl();
        }catch(Exception e){
            System.out.println("Invalid Password for database.");
        }
    }

    //  Method to get a reference to the instance (singleton)
    public static RepositoryService getInstance() {
        return instance;
    }

    // An attribute that stores all restaurants and events (in memory).
    private Map<Integer, Restaurant> restaurantElements;
    private Map<Integer, Event> eventElements;
    private Map<Integer, User> userElements;

    private RepositoryServiceImpl() {
        restaurantElements = new LinkedHashMap<>();
        eventElements = new LinkedHashMap<>();
        userElements = new LinkedHashMap<>();
        entityManagerFactory = Persistence.createEntityManagerFactory("aquadinePU");
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Event> getAllEvents() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Event> events = em.createQuery("SELECT e FROM Event e").getResultList();

        em.close();
        return events;

    }

    @Override
    public int getLatestEvent() {
        EntityManager em = entityManagerFactory.createEntityManager();

        Query query = em.createQuery("SELECT max(e.eventId) from Event e");
        int id = (Integer) query.getSingleResult();
//        int id = et.getEventId();

        em.close();
        return id;

    }

    @Override
    public Response updateUser(int id, User user) {
        EntityManager em = getEntityManager();

        User user2 = em.find(User.class, id);

        em.getTransaction().begin();
        user2.setFirstname(user.getFirstname());
        user2.setSurname(user.getSurname());
        user2.setEmail(user.getEmail());

        user2.setNotifications(user.getNotifications());
        user2.setPassword(user.getPassword());
        user2.setRoles(user.getRoles());
        user2.setPassword(user.getPassword());
        user2.setAvatar(user.getAvatar());


        em.getTransaction().commit();
        em.close();

        return Response.ok().entity(user2).build();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Restaurant> restaurants = em.createQuery("SELECT r FROM Restaurant r").getResultList();

        em.close();
        return restaurants;

    }

    @Override
    public List<Attendeekoppel> getAllKoppels() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Attendeekoppel> koppels = em.createQuery("SELECT u FROM Attendeekoppel u").getResultList();

        em.close();
        return koppels;

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<User> users = em.createQuery("SELECT u FROM User u").getResultList();

        em.close();
        return users;

    }

    @Override
    public List getListKoppels(int eid) {
        EntityManager em = entityManagerFactory.createEntityManager();

//        List users = em.createQuery("SELECT u FROM User u INNER JOIN Attendeekoppel a ON u.userID = a.userId WHERE a.eventId="+ eventId + " ").getResultList();
            List users = em.createQuery("SELECT a, u FROM Attendeekoppel a INNER JOIN User u ON a.userId = u.userID WHERE a.eventId = "+ eid +"").getResultList();
        em.close();
        return users;
    }


    @Override
    public Boolean getUserfromEmail(String email) {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email=email").getResultList();
//        if(users.){
//
//        }

        em.close();
        return true;
    }



    @Override
    public Restaurant addRestaurant(Restaurant rest) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(rest);
        em.getTransaction().commit();

        em.close();

        return rest;
    }


    @Override
    public Event addEvent(Event evt) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(evt);
        em.getTransaction().commit();

        em.close();

        return evt;
    }

    @Override
    public User addUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();

        return user;
    }

    @Override
    public Attendeekoppel addKoppel(Attendeekoppel attendeekoppel) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(attendeekoppel);
        em.getTransaction().commit();

        em.close();

        return attendeekoppel;
    }

    @Override
    public Restaurant getRestaurantfromId(int restaurantId) {

        EntityManager em = getEntityManager();
        Restaurant rs = em.find(Restaurant.class, restaurantId);

        em.close();

        return rs;
    }

    @Override
    public Event getEventfromId(int eventId) {
        EntityManager em = getEntityManager();
        Event ev = em.find(Event.class, eventId);

        em.close();

        return ev;
    }

    @Override
    public List<Event> getEventsfromId(int UID) {
        EntityManager em = getEntityManager();

//        List<Event> ev = em.createQuery("SELECT u FROM User u WHERE u.email=email").getResultList();
//        List<User> users = em.createQuery("SELECT u FROM User u INNER JOIN Attendeekoppel a ON u.userID = a.userId WHERE a.eventId="+ eventId + " ").getResultList();

        List<Event> ev = em.createQuery("SELECT e FROM Event e INNER JOIN Attendeekoppel a ON e.eventId=a.eventId WHERE a.userId=" + UID + " ").getResultList();
//        em.createQuery("");

//        SELECT * FROM event e INNER JOIN attendeeKoppel a ON e.EventID=a.EventID WHERE a.UserID=1;
//        Event ev = em.find(Event.class, userId);

        em.close();

        return ev;
    }

//    @Override
//    public Attendeekoppel getOrderfromId(int eid) {
//        EntityManager em = getEntityManager();
//
//        Query query = em.createQuery("SELECT a FROM Attendeekoppel a WHERE a.userId = " + uid + " AND a.eventId = " + eid + "");
//        Attendeekoppel att = (Attendeekoppel)query.getSingleResult();
//
//        em.close();
//
//        return att;
//    }

    @Override
    public User getUserfromId(int userId) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, userId);

        em.close();

        return user;
    }

    @Override
    public boolean deleteRestaurant(int id) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        Restaurant rest = em.find(Restaurant.class, id);
        em.remove(rest);

        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean deleteAttendee(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        Attendeekoppel rest = em.find(Attendeekoppel.class, id);
        em.remove(rest);

        em.getTransaction().commit();

        em.close();

        return true;
    }

    @Override
    public Response updateRestaurant(int id, Restaurant updateRestaurant) {

        EntityManager em = getEntityManager();

        Restaurant restaurant = em.find(Restaurant.class, id);
        em.getTransaction().begin();
        restaurant.setName(updateRestaurant.getName());
        restaurant.setPhone(updateRestaurant.getPhone());
        restaurant.setEmail(updateRestaurant.getEmail());
        restaurant.setDescription(updateRestaurant.getDescription());
        restaurant.setRestaurantId(updateRestaurant.getRestaurantId());
        em.getTransaction().commit();
        em.close();

        return Response.ok().entity(restaurant).build();
    }

    @Override
    public Response updateOrder(int uid, int eid, Attendeekoppel koppel) {

        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT a FROM Attendeekoppel a WHERE a.eventId =" + eid + " AND a.userId = " + uid + "");
        Attendeekoppel att = (Attendeekoppel)query.getSingleResult();
        //Attendeekoppel att = em.find(Attendeekoppel.class, id);

        em.getTransaction().begin();
        att.setUserOrder(koppel.getUserOrder());
        att.setKoppelID(att.getKoppelID());
        att.setEventId(att.getEventId());
        att.setUserId(att.getUserId());

        em.getTransaction().commit();
        em.close();

        return Response.ok().entity(att).build();
    }


    @Override
    public boolean checkPassword(String email2, String password) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT s FROM User s WHERE s.email ='" + email2 + "' ");
        User u = (User)query.getSingleResult();

        //int id = att.getUserID();
        //User u = em.find(User.class, email2);
        em.close();

        if(u == null) {
            return false;
        }

        return u.checkPassword(password);

    }

    @Override
    public String getRoles(String email2) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT s FROM User s WHERE s.email ='" + email2 + "' ");
        User u = (User)query.getSingleResult();

        //User u = em.find(User.class, email);
        em.close();

        if(u == null) {
            return null;
        }

        return u.getRoles();
    }


}
