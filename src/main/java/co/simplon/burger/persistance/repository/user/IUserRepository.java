package co.simplon.burger.persistance.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.User;

/**
 * Interface for {@link User} repository.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    /**
     * @param username the username to search for
     * @return a list of users with the given username
     */
    @Query(UserQueries.FIND_BY_USERNAME)
    public List<User> findByUsername(final String username);
}
