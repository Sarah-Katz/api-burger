package co.simplon.burger.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.persistance.entity.User;

public class UserConvert {
    private static UserConvert instance;

    private UserConvert() {
    }

    /**
     * @return the user converter's instance
     */
    public static UserConvert getInstance() {
        if (instance == null) {
            instance = new UserConvert();
        }
        return instance;
    }

    /**
     * @param user the user to convert to entity
     * @return the converted entity
     */
    public User toEntity(final UserDto userDto) {
        User user = new User();
        user.setIdUser(userDto.getIdUser());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCity(userDto.getCity());
        user.setAvatar(userDto.getAvatar());
        return user;
    }

    /**
     * @param user the user to convert to dto
     * @return the converted dto
     */
    public UserDto toDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setIdUser(user.getIdUser());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setCity(user.getCity());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }

    /**
     * @param userDtos the users to convert to entities
     * @return the converted entities
     */
    public List<User> listToEntity(final List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            users.add(toEntity(userDto));
        }
        return users;
    }

    /**
     * @param users the users to convert to dtos
     * @return the converted dtos
     */
    public List<UserDto> listToDto(final List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }
}
