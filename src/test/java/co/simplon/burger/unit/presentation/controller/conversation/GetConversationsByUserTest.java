package co.simplon.burger.unit.presentation.controller.conversation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.conversation.IConversationService;
import co.simplon.burger.presentation.controller.conversation.GetConversationsByUserController;

@ExtendWith(MockitoExtension.class)
class GetConversationsByUserTest {
    @InjectMocks
    private GetConversationsByUserController getConversationsByUserController;

    @Mock
    private IConversationService conversationService;

    @Test
    void testGetConversationsByUser() {
        final UserDto userDto = new UserDto();
        when(conversationService.findByUser(userDto)).thenReturn(List.of(new ConversationDto(), new ConversationDto()));
        final List<ConversationDto> conversations = getConversationsByUserController.getConversationsByUser(userDto);
        verify(conversationService, times(1)).findByUser(userDto);
        assertNotNull(conversations);
    }
}
