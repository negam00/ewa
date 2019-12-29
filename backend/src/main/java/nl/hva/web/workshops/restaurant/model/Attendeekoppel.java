package nl.hva.web.workshops.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attendeekoppel", schema = "aquadis")
public class Attendeekoppel implements Serializable {

    @Column(name = "ID")
    private int eventId;

    @Column(name = "ID")
    private int userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KoppelID")
    private int koppelID;

    @Column(name = "userOrder")
    private String userOrder;

    @Id
    @Column(name = "KoppelID", nullable = false)
    public int getKoppelID() {
        return koppelID;
    }

    public void setKoppelID(int koppelID) {
        this.koppelID = koppelID;
    }

    @Column(name = "userOrder", nullable = false)
    public String getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(String order) {
        this.userOrder = order;
    }

    @Column(name = "EventID", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Column(name = "UserID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attendeekoppel that = (Attendeekoppel) o;

        if (eventId != that.eventId) return false;
        if (userId != that.userId) return false;
//todo bven if veranderen
        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + userId;
        return result;
    }
}
