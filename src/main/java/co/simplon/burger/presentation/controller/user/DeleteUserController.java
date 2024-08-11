package co.simplon.burger.presentation.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.service.user.IUserService;

@RestController
@CrossOrigin
public class DeleteUserController {
    private final IUserService userService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param userService
     */
    public DeleteUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Removes an user by its id.
     * 
     * @param id the id of the user to be deleted
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable final int id) {
        userService.deleteUser(id);
    }
}
