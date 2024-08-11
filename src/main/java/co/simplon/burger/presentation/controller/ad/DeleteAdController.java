package co.simplon.burger.presentation.controller.ad;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.service.ad.IAdService;

@RestController
@CrossOrigin
public class DeleteAdController {
    private final IAdService adService;

    /**
     * Dependencies injection for the Controller.
     * @param adService
     */
    public DeleteAdController(IAdService adService) {
        this.adService = adService;
    }

    /**
     * Removes an ad by its id.
     * @param id the id of the ad to be deleted
     */
    @DeleteMapping("/ads/{id}")
    public void deleteAd(@PathVariable final int id) {
        adService.deleteAd(id);
    }
}
