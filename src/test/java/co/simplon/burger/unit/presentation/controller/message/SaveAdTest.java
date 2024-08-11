package co.simplon.burger.unit.presentation.controller.message;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.service.message.IMessageService;
import co.simplon.burger.presentation.controller.message.SaveMessageController;

@ExtendWith(MockitoExtension.class)
class SaveMessageTest {
    @InjectMocks
    private SaveMessageController saveMessageController;

    @Mock
    private IMessageService messageService;

    @Test
    void testSaveMessage() {
        final MessageDto messageDto = new MessageDto();
        doNothing().when(messageService).saveMessage(messageDto);
        saveMessageController.saveMessage(messageDto);
        verify(messageService, times(1)).saveMessage(messageDto);
    }
}
