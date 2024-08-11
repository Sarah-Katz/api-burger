package co.simplon.burger.unit.persistance.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.user.IUserRepository;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {
    @Mock
    private IUserRepository userRepository;

    @Test
    void testQueryUsersByUsername() {
        final String username = "John Doe";
        when(userRepository.findByUsername(username)).thenReturn(List.of(new User(), new User()));
        final List<User> users = userRepository.findByUsername(username);
        verify(userRepository, times(1)).findByUsername(username);
        assert users != null;
    }
}
