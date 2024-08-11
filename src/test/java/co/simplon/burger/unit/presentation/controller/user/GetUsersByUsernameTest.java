package co.simplon.burger.unit.presentation.controller.user;

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

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.user.IUserService;
import co.simplon.burger.presentation.controller.user.GetUsersByUsernameController;

@ExtendWith(MockitoExtension.class)
class GetUsersByUsernameTest {
    @InjectMocks
    private GetUsersByUsernameController getUsersByUsernameController;

    @Mock
    private IUserService userService;

    @Test
    void testGetUsersByUsername() {
        final String username = "testUser";
        when(userService.getUsersByUsername(username)).thenReturn(List.of(new UserDto(), new UserDto()));
        final List<UserDto> users = getUsersByUsernameController.getUsersByUsername(username);
        verify(userService, times(1)).getUsersByUsername(username);
        assertNotNull(users);
    }
}
