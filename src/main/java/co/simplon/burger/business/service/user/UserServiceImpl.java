package co.simplon.burger.business.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.burger.business.convert.UserConvert;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.persistance.repository.user.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
    private IUserRepository userRepository;

    /**
     * Injects the required dependencies to the service.
     * 
     * @param userRepository
     */
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto user) {
        userRepository.save(UserConvert.getInstance().toEntity(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserConvert.getInstance().listToDto(userRepository.findAll());
    }

    @Override
    public List<UserDto> getUsersByUsername(final String username) {
        return UserConvert.getInstance().listToDto(userRepository.findByUsername(username));
    }

    @Override
    public void deleteUser(final int userId) {
        userRepository.deleteById(userId);
    }

}
