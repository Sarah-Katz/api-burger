package co.simplon.burger.unit.presentation.controller.ad;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.service.ad.IAdService;
import co.simplon.burger.presentation.controller.ad.SaveAdController;

@ExtendWith(MockitoExtension.class)
class SaveAdTest {
    @InjectMocks
    private SaveAdController saveAdController;

    @Mock
    private IAdService adService;

    @Test
    void testSaveAd() {
        final AdDto adDto = new AdDto();
        doNothing().when(adService).saveAd(adDto);
        saveAdController.saveAd(adDto);
        verify(adService, times(1)).saveAd(adDto);
    }
}
