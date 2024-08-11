package co.simplon.burger.unit.presentation.controller.user;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.user.IUserService;
import co.simplon.burger.presentation.controller.user.SaveUserController;

@ExtendWith(MockitoExtension.class)
class SaveUserTest {
    @InjectMocks
    private SaveUserController saveUserController;

    @Mock
    private IUserService userService;

    @Test
    void testSaveUser() {
        final UserDto userDto = new UserDto();
        doNothing().when(userService).saveUser(userDto);
        saveUserController.saveUser(userDto);
        verify(userService, times(1)).saveUser(userDto);
    }
}
