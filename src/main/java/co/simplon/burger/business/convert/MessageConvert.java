package co.simplon.burger.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.persistance.entity.Message;

public class MessageConvert {
    private static MessageConvert instance;

    private MessageConvert() {
    }

    /**
     * @return the message converter's instance
     */
    public static MessageConvert getInstance() {
        if (instance == null) {
            instance = new MessageConvert();
        }
        return instance;
    }

    /**
     * @param messageDto the message to convert to entity
     * @return the converted entity
     */
    public Message toEntity(final MessageDto messageDto) {
        final Message message = new Message();
        message.setIdMessage(messageDto.getIdMessage());
        message.setIdSender(messageDto.getIdSender());
        message.setText(messageDto.getText());
        message.setDateTime(messageDto.getDateTime());
        return message;
    }

    /**
     * @param message the message to convert to dto
     * @return the converted dto
     */
    public MessageDto toDto(final Message message) {
        final MessageDto messageDto = new MessageDto();
        messageDto.setIdMessage(message.getIdMessage());
        messageDto.setIdSender(message.getIdSender());
        messageDto.setText(message.getText());
        messageDto.setDateTime(message.getDateTime());
        return messageDto;
    }

    /**
     * @param messageDtos the messages to convert to entities
     * @return the converted entities
     */
    public List<Message> listToEntity(final List<MessageDto> messageDtos) {
        final List<Message> messages = new ArrayList<>();
        for (final MessageDto messageDto : messageDtos) {
            messages.add(toEntity(messageDto));
        }
        return messages;
    }

    /**
     * @param messages the messages to convert to dtos
     * @return the converted dtos
     */
    public List<MessageDto> listToDto(final List<Message> messages) {
        final List<MessageDto> messageDtos = new ArrayList<>();
        for (final Message message : messages) {
            messageDtos.add(toDto(message));
        }
        return messageDtos;
    }
}
