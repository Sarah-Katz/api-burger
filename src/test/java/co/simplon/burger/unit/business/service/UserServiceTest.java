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

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.user.UserServiceImpl;
import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.user.IUserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    IUserRepository userRepository;

    @Test
    void testSaveUser() {
        UserDto userDto = new UserDto();
        when(userRepository.save(any(User.class))).thenReturn(null);
        userService.saveUser(userDto);

        // Verify that the save method was called once
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        List<UserDto> users = userService.getAllUsers();

        // Verify that the findAll method was called once
        verify(userRepository, times(1)).findAll();
        assertTrue(!users.isEmpty());
    }

    @Test
    void testGetUsersByUsername() {
        when(userRepository.findByUsername(any(String.class))).thenReturn(List.of(new User(), new User()));
        List<UserDto> users = userService.getUsersByUsername("username");

        // Verify that the findByUsername method was called once
        verify(userRepository, times(1)).findByUsername(any(String.class));
        assertTrue(!users.isEmpty());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(any(int.class));
        userService.deleteUser(1);

        // Verify that the deleteById method was called once
        verify(userRepository, times(1)).deleteById(any(int.class));
    }
}
