package co.simplon.burger.persistance.repository.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.Message;

/**
 * Interface for {@link Message} repository.
 */
@Repository
public interface IMessageRepository extends JpaRepository<Message, Integer> {
}
