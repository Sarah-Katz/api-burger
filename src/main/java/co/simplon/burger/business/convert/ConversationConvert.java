package co.simplon.burger.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.persistance.entity.Conversation;

public class ConversationConvert {
    private static ConversationConvert instance;

    private ConversationConvert() {
    }

    /**
     * @return the conversation converter's instance
     */
    public static ConversationConvert getInstance() {
        if (instance == null) {
            instance = new ConversationConvert();
        }
        return instance;
    }

    /**
     * @param conversationDto the conversation to convert to entity
     * @return the converted entity
     */
    public Conversation toEntity(final ConversationDto conversationDto) {
        final Conversation conversation = new Conversation();
        conversation.setIdConversation(conversationDto.getIdConversation());
        
        // If there are users, convert them
        if (conversationDto.getUsers()!= null) {
            conversation.setUsers(UserConvert.getInstance().listToEntity(conversationDto.getUsers()));
        }

        // If there are messages, convert them
        if (conversationDto.getMessages()!= null) {
            conversation.setMessages(MessageConvert.getInstance().listToEntity(conversationDto.getMessages()));
        }

        // If there are transactions, convert them
        if (conversationDto.getTransactions()!= null) {
            conversation.setTransactions(TransactionConvert.getInstance().listToEntity(conversationDto.getTransactions()));
        }
        return conversation;
    }

    /**
     * @param conversation the conversation to convert to dto
     * @return the converted dto
     */
    public ConversationDto toDto(final Conversation conversation) {
        final ConversationDto conversationDto = new ConversationDto();
        conversationDto.setIdConversation(conversation.getIdConversation());

        // If there are users, convert them
        if (conversation.getUsers()!= null) {
            conversationDto.setUsers(UserConvert.getInstance().listToDto(conversation.getUsers()));
        }

        // If there are messages, convert them
        if (conversation.getMessages()!= null) {
            conversationDto.setMessages(MessageConvert.getInstance().listToDto(conversation.getMessages()));
        }

        // If there are transactions, convert them
        if (conversation.getTransactions()!= null) {
            conversationDto.setTransactions(TransactionConvert.getInstance().listToDto(conversation.getTransactions()));
        }
        return conversationDto;
    }

    /**
     * @param conversationDtos the conversations to convert to entities
     * @return the converted entities
     */
    public List<Conversation> listToEntity(final List<ConversationDto> conversationDtos) {
        final List<Conversation> conversations = new ArrayList<>();
        for (final ConversationDto conversationDto : conversationDtos) {
            conversations.add(toEntity(conversationDto));
        }
        return conversations;
    }

    /**
     * @param conversations the conversations to convert to dtos
     * @return the converted dtos
     */
    public List<ConversationDto> listToDto(final List<Conversation> conversations) {
        final List<ConversationDto> conversationDtos = new ArrayList<>();
        for (final Conversation conversation : conversations) {
            conversationDtos.add(toDto(conversation));
        }
        return conversationDtos;
    }
}
