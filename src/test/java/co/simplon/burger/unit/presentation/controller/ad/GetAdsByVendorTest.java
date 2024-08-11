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
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.ad.IAdService;
import co.simplon.burger.presentation.controller.ad.GetAdsByVendorController;

@ExtendWith(MockitoExtension.class)
class GetAdsByVendorTest {
    @InjectMocks
    private GetAdsByVendorController getAdsByVendorController;

    @Mock
    private IAdService adService;

    @Test
    void testGetAdsByVendor() {
        final UserDto userDto = new UserDto();
        when(adService.getAllAdsForVendor(userDto)).thenReturn(List.of(new AdDto(), new AdDto()));
        final List<AdDto> ads = getAdsByVendorController.getAdsByVendor(userDto);
        verify(adService, times(1)).getAllAdsForVendor(userDto);
        assertNotNull(ads);
    }
}
