package co.simplon.burger.unit.presentation.controller.conversation;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.service.conversation.IConversationService;
import co.simplon.burger.presentation.controller.conversation.SaveConversationController;

@ExtendWith(MockitoExtension.class)
class SaveConversationTest {
    @InjectMocks
    private SaveConversationController saveConversationController;

    @Mock
    private IConversationService conversationService;

    @Test
    void testSaveConversation() {
        final ConversationDto conversationDto = new ConversationDto();
        doNothing().when(conversationService).saveConversation(conversationDto);
        saveConversationController.saveConversation(conversationDto);
        verify(conversationService, times(1)).saveConversation(conversationDto);
    }
}
