package co.simplon.burger.presentation.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.user.IUserService;

@RestController
@CrossOrigin
public class GetUsersByUsernameController {
    private final IUserService userService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param userService
     */
    public GetUsersByUsernameController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Returns all users with the given username.
     * 
     * @param username The username to search for.
     * @return A list of {@link UserDto} objects with the given username.
     */
    @GetMapping("/users/byUsername/{username}")
    public List<UserDto> getUsersByUsername(@PathVariable final String username) {
        return userService.getUsersByUsername(username);
    }
}
