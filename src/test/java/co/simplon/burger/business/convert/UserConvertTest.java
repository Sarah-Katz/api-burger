package co.simplon.burger.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.persistance.entity.User;

public class UserConvertTest {
    private static UserConvert userConvert = UserConvert.getInstance();

    @Test
    void testToEntity() {
        UserDto userDto = new UserDto();
        User user = userConvert.toEntity(userDto);
        assertEquals(User.class, user.getClass());
    }

    @Test
    void testToDto() {
        User user = new User();
        UserDto userDto = userConvert.toDto(user);
        assertEquals(UserDto.class, userDto.getClass());
    }

    @Test
    void testToDtoList() {
        List<User> users = List.of(new User(), new User());
        List<UserDto> userDtos = userConvert.listToDto(users);
        assertEquals(UserDto.class, userDtos.get(0).getClass());
    }

    @Test
    void testToEntityList() {
        List<UserDto> userDtos = List.of(new UserDto(), new UserDto());
        List<User> users = userConvert.listToEntity(userDtos);
        assertEquals(User.class, users.get(0).getClass());
    }
}
