package co.simplon.burger.unit.persistance.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.ad.IAdRepository;

@ExtendWith(MockitoExtension.class)
class AdRepositoryTest {
    @Mock
    private IAdRepository adRepository;

    @Test
    void testQueryAdsByUser() {
        final User user = new User();
        when(adRepository.findByVendor(user)).thenReturn(List.of(new Ad(), new Ad()));
        final List<Ad> ads = adRepository.findByVendor(user);
        verify(adRepository, times(1)).findByVendor(user);
        assert ads != null;
    }
}
