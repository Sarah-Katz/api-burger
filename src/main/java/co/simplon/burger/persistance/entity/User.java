package co.simplon.burger.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "avatar", columnDefinition = "TEXT")
    private String avatar;

    /**
     * @return The user's id
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser The user's id to set
     */
    public void setIdUser(final int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The user's username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return The user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The user's email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The user's password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return The user's city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The user's city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return The user's avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar The user's avatar to set
     */
    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }
}
