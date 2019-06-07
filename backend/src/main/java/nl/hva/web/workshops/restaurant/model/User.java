package nl.hva.web.workshops.restaurant.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Table(name = "user", schema = "aquadis", catalog = "")
public class User implements Serializable {

    @Column(name="UserID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name="Email")
    private String email;

    @Column(name="Firstname")
    private String firstname;

    @Column(name="Surname")
    private String surname;

    @Column(name="\"Password\"")
    private String password;

    @Column(name="Notifications")
    private int notifications;

    @Column(name="Role")
    private String roles;

    @Column(name="Avatar")
    private String avatar;

    public User(){}

    public User(String email, String firstname, String Surname, String Password, String roles){
        setEmail(email);
        setFirstname(firstname);
        setSurname(Surname);
        setPassword(Password);
        setRoles(roles);
    }

    // getters & setters
    @Id
    @Column(name = "UserID", nullable = false)
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "Firstname", nullable = true, length = 45)
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "Surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "\"Password\"", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
//        this.password = Base64.getEncoder().encodeToString(password.getBytes());
        this.password = password;
    }

    @Basic
    @Column(name = "Notifications", nullable = true, length = 45)
    public int getNotifications() {
        return notifications;
    }
    public void setNotifications(int notifications) {
        this.notifications = notifications;
    }

    @Basic
    @Column(name = "Avatar", nullable = true, length = 45)
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "Role", nullable = true, length = 45)
    public String getRoles() {
        return roles;
    }
    public void setRoles(String role){
        this.roles = role;
    }

    public boolean checkPassword(String ref) {
//        String ref2 = Base64.getEncoder().encodeToString(ref.getBytes());

        return ref.equals(getPassword());
    }




}
