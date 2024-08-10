package co.simplon.burger.business.service.user;

import java.util.List;

import co.simplon.burger.business.dto.UserDto;

public interface IUserService {
    /**
     * Creates or updates a user if it already exists.
     * @param userDto User to be saved
     */
    public void saveUser(final UserDto userDto);

    /**
     * Gets all users by a given username.
     * @param username Username of the users to be retrieved
     * @return List of users with the given username
     */
    public List<UserDto> getUsersByUsername(final String username);

    /**
     * Deletes a user.
     * @param userId User's id
     */
    public void deleteUser(final int userId);
}
