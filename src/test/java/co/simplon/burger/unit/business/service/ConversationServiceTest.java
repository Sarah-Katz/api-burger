package co.simplon.burger.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.conversation.ConversationServiceImpl;
import co.simplon.burger.persistance.entity.Conversation;
import co.simplon.burger.persistance.entity.User;
import co.simplon.burger.persistance.repository.conversation.IConversationRepository;

@ExtendWith(MockitoExtension.class)
class ConversationServiceTest {
    @InjectMocks
    ConversationServiceImpl conversationService;

    @Mock
    IConversationRepository conversationRepository;

    @Test
    void testSaveConversation() {
        ConversationDto conversationDto = new ConversationDto();
        when(conversationRepository.save(any(Conversation.class))).thenReturn(null);
        conversationService.saveConversation(conversationDto);

        // Verify that the save method was called once
        verify(conversationRepository, times(1)).save(any(Conversation.class));
    }

    @Test
    void testFindByUser() {
        final UserDto user = new UserDto();
        when(conversationRepository.findByUser(any(User.class)))
                .thenReturn(List.of(new Conversation(), new Conversation()));
        List<ConversationDto> conversations = conversationService.findByUser(user);

        // Verify that the findByUser method was called once
        verify(conversationRepository, times(1)).findByUser(any(User.class));
        assertTrue(!conversations.isEmpty());
    }

    @Test
    void testAddMessage() {
        final ConversationDto conversation = new ConversationDto();
        final MessageDto message = new MessageDto();
        when(conversationRepository.save(any(Conversation.class))).thenReturn(null);
        conversationService.addMessage(conversation, message);

        // Verify that the save method was called once
        verify(conversationRepository, times(1)).save(any(Conversation.class));
    }

    @Test
    void addTransaction() {
        final ConversationDto conversation = new ConversationDto();
        final TransactionDto transaction = new TransactionDto();
        when(conversationRepository.save(any(Conversation.class))).thenReturn(null);
        conversationService.addTransaction(conversation, transaction);

        // Verify that the save method was called once
        verify(conversationRepository, times(1)).save(any(Conversation.class));
    }
}
