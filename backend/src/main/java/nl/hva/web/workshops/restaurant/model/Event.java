package nl.hva.web.workshops.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "event", schema = "aquadis", catalog = "")
public class Event implements Serializable {

    @Column(name = "EventID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;

    @Column(name = "RestaurantID")
    private int restaurantId;

    @Column(name = "Name")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Column(name = "EventDate")
    private Date eventDate;

    @Column(name = "Descr")
    private String descr;

    @Column(name = "ManagerID")
    private int managerID;

    public Event(int restaurantId, String name, String descr, Date eventDate, int managerID) {
        setDescr(descr);
        setName(name);
        setRestaurantId(restaurantId);
        setDate(eventDate);
        setManagerID(managerID);

    }

    public Event() {
    }

    @Id
    @Column(name = "EventID")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "RestaurantID")
    public int getRestaurantId() {

        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", locale = "nl_NL")
    @Column(name = "EventDate")
    public Date getDate() {
        return eventDate;
    }

    public void setDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Basic
    @Column(name = "ManagerID")
    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    @Basic
    @Column(name = "Descr")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        if (eventId != that.eventId) return false;
        if (restaurantId != that.restaurantId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (eventDate != null ? !eventDate.equals(that.eventDate) : that.eventDate != null) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;
//todo if state,emt
        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + restaurantId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }
}
