package co.simplon.burger.presentation.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.user.IUserService;

@RestController
@CrossOrigin
public class SaveUserController {
    private final IUserService userService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param userController
     */
    public SaveUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Saves a new user or updates an existing one.
     * 
     * @param userDto The {@link UserDto} object to be saved or updated.
     */
    @PostMapping("/users")
    public void saveUser(@RequestBody final UserDto userDto) {
        userService.saveUser(userDto);
    }
}
