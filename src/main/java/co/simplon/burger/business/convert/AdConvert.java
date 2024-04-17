package co.simplon.burger.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.persistance.entity.Ad;

public class AdConvert {
    private static AdConvert instance;

    private AdConvert() {
    }

    /**
     * @return the ad converter's instance
     */
    public static AdConvert getInstance() {
        if (instance == null) {
            instance = new AdConvert();
        }
        return instance;
    }

    /**
     * @param adDto the ad to convert to entity
     * @return the converted entity
     */
    public Ad toEntity(final AdDto adDto) {
        final Ad ad = new Ad();
        ad.setIdAd(adDto.getIdAd());
        ad.setVendor(adDto.getVendor() != null ? UserConvert.getInstance().toEntity(adDto.getVendor()) : null);
        ad.setImages(adDto.getImages());
        ad.setTitle(adDto.getTitle());
        ad.setDescription(adDto.getDescription());
        ad.setPrice(adDto.getPrice());
        ad.setLiked(adDto.getLiked() != null ? UserConvert.getInstance().listToEntity(adDto.getLiked()) : null);
        return ad;
    }

    /**
     * @param ad the ad to convert to dto
     * @return the converted dto
     */
    public AdDto toDto(final Ad ad) {
        final AdDto adDto = new AdDto();
        adDto.setIdAd(ad.getIdAd());
        adDto.setVendor(ad.getVendor() != null ? UserConvert.getInstance().toDto(ad.getVendor()) : null);
        adDto.setImages(ad.getImages());
        adDto.setTitle(ad.getTitle());
        adDto.setDescription(ad.getDescription());
        adDto.setPrice(ad.getPrice());
        adDto.setLiked(ad.getLiked() != null ? UserConvert.getInstance().listToDto(ad.getLiked()) : null);
        return adDto;
    }

    /**
     * @param adDtos the ads to convert to entities
     * @return the converted entities
     */
    public List<Ad> listToEntity(final List<AdDto> adDtos) {
        final List<Ad> ads = new ArrayList<>();
        for (final AdDto adDto : adDtos) {
            ads.add(toEntity(adDto));
        }
        return ads;
    }

    /**
     * @param ads the ads to convert to dtos
     * @return the converted dtos
     */
    public List<AdDto> listToDto(final List<Ad> ads) {
        final List<AdDto> adDtos = new ArrayList<>();
        for (final Ad ad : ads) {
            adDtos.add(toDto(ad));
        }
        return adDtos;
    }
}
