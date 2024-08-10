package co.simplon.burger.business.service.conversation;

import java.util.List;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.dto.UserDto;

public interface IConversationService {

    /**
     * Creates or updates a conversation if it doesn't exist.
     * @param conversation The conversation to be saved.
     */
    public void saveConversation(final ConversationDto conversation);

    /**
     * Get the conversations associated with a user.
     * @param user The user whose conversations we want to retrieve.
     * @return The conversations associated with the given user, or null if no conversation exists.
     */
    public List<ConversationDto> findByUser(final UserDto user);

    /**
     * Add a message to a conversation.
     * @param conversation The conversation to which the message will be added.
     * @param message The message to be added to the conversation.
     */
    public void addMessage(final ConversationDto conversation, final MessageDto message);

    /**
     * Add a transaction to a conversation.
     * @param conversation The conversation to which the transaction will be added.
     * @param transaction The transaction to be added to the conversation.
     */
    public void addTransaction(final ConversationDto conversation, final TransactionDto transaction);

}
