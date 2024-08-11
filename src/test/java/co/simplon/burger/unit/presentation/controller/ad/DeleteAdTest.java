package co.simplon.burger.unit.presentation.controller.ad;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.service.ad.IAdService;
import co.simplon.burger.presentation.controller.ad.DeleteAdController;

@ExtendWith(MockitoExtension.class)
class DeleteAdTest {
    @InjectMocks
    private DeleteAdController controller;

    @Mock
    private IAdService adService;

    @Test
    void testDeleteAd() {
        final int id = 1;
        doNothing().when(adService).deleteAd(id);
        controller.deleteAd(id);
        verify(adService, times(1)).deleteAd(id);
    }
}
