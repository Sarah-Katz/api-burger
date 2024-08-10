package co.simplon.burger.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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
import co.simplon.burger.business.service.ad.AdServiceImpl;
import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.ad.IAdRepository;

@ExtendWith(MockitoExtension.class)
class AdServiceTest {
    @InjectMocks
    AdServiceImpl adService;

    @Mock
    IAdRepository adRepository;

    @Test
    void testSaveAd() {
        AdDto adDto = new AdDto();
        when(adRepository.save(any(Ad.class))).thenReturn(null);
        adService.saveAd(adDto);

        // Verify that the save method was called once
        verify(adRepository, times(1)).save(any(Ad.class));
    }

    @Test
    void testGetAdsByVendor() {
        UserDto user = new UserDto();
        when(adRepository.findByVendor(any(User.class))).thenReturn(List.of(new Ad(), new Ad()));
        List<AdDto> ads = adService.getAllAdsForVendor(user);

        // Verify that the findByVendor method was called once
        verify(adRepository, times(1)).findByVendor(any(User.class));
        assertTrue(!ads.isEmpty());
    }

    @Test
    void testDeleteAd() {
        doNothing().when(adRepository).deleteById(any(int.class));
        adService.deleteAd(1);

        // Verify that the deleteById method was called once
        verify(adRepository, times(1)).deleteById(any(int.class));
    }
}
