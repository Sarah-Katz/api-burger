package co.simplon.burger.presentation.controller.ad;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.service.ad.IAdService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class SaveAdController {
    private final IAdService adService;

    /**
     * Dependencies injection for the Controller.
     * @param adService
     */
    public SaveAdController(final IAdService adService) {
        this.adService = adService;
    }

    /**
     * Creates or updates an ad if it already exists.
     * @param ad the {@link AdDto} to be saved
     */
    @PostMapping("/ads")
    public void saveAd(@RequestBody final AdDto ad) {
        adService.saveAd(ad);
    }
}
