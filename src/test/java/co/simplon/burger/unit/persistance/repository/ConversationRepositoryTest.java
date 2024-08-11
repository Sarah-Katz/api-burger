package co.simplon.burger.unit.persistance.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.persistance.entity.Conversation;
import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.conversation.IConversationRepository;

@ExtendWith(MockitoExtension.class)
class ConversationRepositoryTest {
    @Mock
    private IConversationRepository conversationRepository;

    @Test
    void testQueryConversationsByUser() {
        final User user = new User();
        when(conversationRepository.findByUser(user)).thenReturn(List.of(new Conversation(), new Conversation()));
        final List<Conversation> conversations = conversationRepository.findByUser(user);
        verify(conversationRepository, times(1)).findByUser(user);
        assert conversations != null;
    }
}
