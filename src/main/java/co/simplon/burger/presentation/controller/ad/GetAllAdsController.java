package co.simplon.burger.presentation.controller.ad;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.service.ad.IAdService;

@RestController
@CrossOrigin
public class GetAllAdsController {
    private IAdService adService;

    /**
     * Dependencies injection for the Constructor.
     * 
     * @param adService
     */
    public GetAllAdsController(final IAdService adService) {
        this.adService = adService;
    }

    /**
     * Method to get all ads.
     * @return a list of all {@link AdDto}.
     */
    @GetMapping("/ads")
    public List<AdDto> getAllAds() {
        return adService.getAllAds();
    }
}
