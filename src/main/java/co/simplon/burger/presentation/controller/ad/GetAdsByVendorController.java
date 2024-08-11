package co.simplon.burger.presentation.controller.ad;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.ad.IAdService;

@RestController
@CrossOrigin
public class GetAdsByVendorController {
    private final IAdService adService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param adService
     */
    public GetAdsByVendorController(final IAdService adService) {
        this.adService = adService;
    }

    /**
     * Returns all ads for a specific vendor.
     * 
     * @param user the {@link UserDto} who owns the ads
     */
    @GetMapping("/ads/byVendor")
    public List<AdDto> getAdsByVendor(@RequestBody final UserDto user) {
        return adService.getAllAdsForVendor(user);
    }
}
