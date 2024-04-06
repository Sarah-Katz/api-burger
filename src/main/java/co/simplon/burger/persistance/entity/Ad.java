package co.simplon.burger.persistance.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ad")
    private int idAd;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User vendor;

    @Column(name = "images")
    private List<String> images;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToMany
    @JoinTable(name = "ad_user", joinColumns = @JoinColumn(name = "id_ad"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> liked;

    /**
     * @return The ad's id
     */
    public int getIdAd() {
        return idAd;
    }

    /**
     * @param idAd The ad's id
     */
    public void setIdAd(final int idAd) {
        this.idAd = idAd;
    }

    /**
     * @return The ad's vendor
     */
    public User getVendor() {
        return vendor;
    }

    /**
     * @param vendor The ad's vendor
     */
    public void setVendor(final User vendor) {
        this.vendor = vendor;
    }

    /**
     * @return The ad's images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images The ad's images
     */
    public void setImages(final List<String> images) {
        this.images = images;
    }

    /**
     * @return The ad's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The ad's title
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return The ad's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The ad's description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return The ad's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price The ad's price
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * @return The ad's list of user who liked it
     */
    public List<User> getLiked() {
        return liked;
    }

    /**
     * @param liked The ad's list of user who liked it
     */
    public void setLiked(final List<User> liked) {
        this.liked = liked;
    }
}
