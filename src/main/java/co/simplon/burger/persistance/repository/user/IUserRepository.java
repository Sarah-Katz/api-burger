package co.simplon.burger.persistance.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(UserQueries.FIND_BY_USERNAME)
    public List<User> findByUsername(final String username);
}
