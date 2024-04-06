package co.simplon.burger.persistance.repository.conversation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.Conversation;
import co.simplon.burger.persistance.entity.User;

@Repository
public interface IConversationRepository extends JpaRepository<Conversation, Integer>{
    @Query(ConversationQueries.FIND_BY_USER)
    List<Conversation> findByUser(final User user);
}
