package co.simplon.burger.business.service.ad;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.burger.business.convert.AdConvert;
import co.simplon.burger.business.convert.UserConvert;
import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.persistance.repository.ad.IAdRepository;

@Service
public class AdServiceImpl implements IAdService {
    private IAdRepository adRepository;

    /**
     * Injects the required dependencies to the service.
     * 
     * @param adRepository
     */
    public AdServiceImpl(final IAdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public void saveAd(final AdDto adDto) {
        adRepository.save(AdConvert.getInstance().toEntity(adDto));
    }

    @Override
    public List<AdDto> getAllAdsForVendor(final UserDto user) {
        return AdConvert.getInstance().listToDto(adRepository.findByVendor(UserConvert.getInstance().toEntity(user)));
    }

    @Override
    public void deleteAd(final int adId) {
        adRepository.deleteById(adId);
    }
}
