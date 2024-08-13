package co.simplon.burger.unit.presentation.controller.ad;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.service.ad.IAdService;
import co.simplon.burger.presentation.controller.ad.GetAllAdsController;

@ExtendWith(MockitoExtension.class)
class GetAllAdsTest {
    @InjectMocks
    private GetAllAdsController getAllAdsController;

    @Mock
    private IAdService adService;

    @Test
    void testGetAllAds() {
        when(adService.getAllAds()).thenReturn(List.of(new AdDto(), new AdDto()));
        final List<AdDto> ads = getAllAdsController.getAllAds();
        verify(adService, times(1)).getAllAds();
        assertNotNull(ads);
    }
}
