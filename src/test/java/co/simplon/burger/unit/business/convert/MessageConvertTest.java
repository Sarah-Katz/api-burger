package co.simplon.burger.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.burger.business.convert.MessageConvert;
import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.persistance.entity.Message;

class MessageConvertTest {
    private static MessageConvert messageConvert = MessageConvert.getInstance();

    @Test
    void testToEntity() {
        MessageDto messageDto = new MessageDto();
        Message message = messageConvert.toEntity(messageDto);
        assertEquals(Message.class, message.getClass());
    }

    @Test
    void testToDto() {
        Message message = new Message();
        MessageDto messageDto = messageConvert.toDto(message);
        assertEquals(MessageDto.class, messageDto.getClass());
    }

    @Test
    void testToDtoList() {
        List<Message> messages = List.of(new Message(), new Message());
        List<MessageDto> messageDtos = messageConvert.listToDto(messages);
        assertEquals(MessageDto.class, messageDtos.get(0).getClass());
    }

    @Test
    void testToEntityList() {
        List<MessageDto> messageDtos = List.of(new MessageDto(), new MessageDto());
        List<Message> messages = messageConvert.listToEntity(messageDtos);
        assertEquals(Message.class, messages.get(0).getClass());
    }
}
