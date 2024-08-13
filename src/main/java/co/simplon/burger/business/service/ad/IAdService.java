package co.simplon.burger.business.service.ad;

import java.util.List;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.UserDto;

public interface IAdService {
    /**
     * Creates or updates an ad if it already exists.
     * 
     * @param adDto Ad to be saved
     */
    public void saveAd(final AdDto adDto);

    /**
     * @return A list of all {@link AdDto}
     */
    public List<AdDto> getAllAds();

    /**
     * Gets all ads for a given vendor.
     * 
     * @param user User who owns the ads
     * @return List of ads for the vendor
     */
    public List<AdDto> getAllAdsForVendor(final UserDto user);

    /**
     * Deletes an ad.
     * 
     * @param adId Ad's id
     */
    public void deleteAd(final int adId);
}
