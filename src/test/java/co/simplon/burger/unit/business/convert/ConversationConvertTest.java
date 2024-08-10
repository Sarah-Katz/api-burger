package co.simplon.burger.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.burger.business.convert.ConversationConvert;
import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.persistance.entity.Conversation;

class ConversationConvertTest {
    private static ConversationConvert conversationConvert = ConversationConvert.getInstance();

    @Test
    void testToEntity() {
        ConversationDto conversationDto = new ConversationDto();
        Conversation conversation = conversationConvert.toEntity(conversationDto);
        assertEquals(Conversation.class, conversation.getClass());
    }

    @Test
    void testToDto() {
        Conversation conversation = new Conversation();
        ConversationDto conversationDto = conversationConvert.toDto(conversation);
        assertEquals(ConversationDto.class, conversationDto.getClass());
    }

    @Test
    void testToDtoList() {
        List<Conversation> conversations = List.of(new Conversation(), new Conversation());
        List<ConversationDto> conversationDtos = conversationConvert.listToDto(conversations);
        assertEquals(ConversationDto.class, conversationDtos.get(0).getClass());
    }

    @Test
    void testToEntityList() {
        List<ConversationDto> conversationDtos = List.of(new ConversationDto(), new ConversationDto());
        List<Conversation> conversations = conversationConvert.listToEntity(conversationDtos);
        assertEquals(Conversation.class, conversations.get(0).getClass());
    }
}
