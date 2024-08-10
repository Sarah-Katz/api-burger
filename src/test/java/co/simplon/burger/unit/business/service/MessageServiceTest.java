package co.simplon.burger.unit.business.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.service.message.MessageServiceImpl;
import co.simplon.burger.persistance.entity.Message;
import co.simplon.burger.persistance.repository.message.IMessageRepository;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
    @InjectMocks
    MessageServiceImpl messageService;

    @Mock
    IMessageRepository messageRepository;

    @Test
    void testSaveMessage() {
        MessageDto messageDto = new MessageDto();
        when(messageRepository.save(any(Message.class))).thenReturn(null);
        messageService.saveMessage(messageDto);

        // Verify that the save method was called once
        verify(messageRepository, times(1)).save(any(Message.class));
    }
}
