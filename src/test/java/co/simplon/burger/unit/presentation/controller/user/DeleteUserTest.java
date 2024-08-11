package co.simplon.burger.unit.presentation.controller.user;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.service.user.IUserService;
import co.simplon.burger.presentation.controller.user.DeleteUserController;

@ExtendWith(MockitoExtension.class)
class DeleteUserTest {
    @InjectMocks
    private DeleteUserController controller;

    @Mock
    private IUserService userService;

    @Test
    void testDeleteUser() {
        final int id = 1;
        doNothing().when(userService).deleteUser(id);
        controller.deleteUser(id);
        verify(userService, times(1)).deleteUser(id);
    }
}
