package co.simplon.burger.business.dto;

import java.util.List;

public class AdDto {
    private int idAd;
    private UserDto vendor;
    private List<String> images;
    private String title;
    private String description;
    private double price;
    private List<UserDto> liked;

    /**
     * @return the idAd
     */
    public int getIdAd() {
        return idAd;
    }

    /**
     * @param idAd the idAd to set
     */
    public void setIdAd(final int idAd) {
        this.idAd = idAd;
    }

    /**
     * @return the vendor
     */
    public UserDto getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(final UserDto vendor) {
        this.vendor = vendor;
    }

    /**
     * @return the images source url
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images the images source url to set
     */
    public void setImages(final List<String> images) {
        this.images = images;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * @return the list of users who liked the ad
     */
    public List<UserDto> getLiked() {
        return liked;
    }

    /**
     * @param liked the list of users who liked the ad to set
     */
    public void setLiked(final List<UserDto> liked) {
        this.liked = liked;
    }
}
