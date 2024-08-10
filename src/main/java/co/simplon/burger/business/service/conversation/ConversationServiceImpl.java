package co.simplon.burger.business.service.conversation;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.convert.ConversationConvert;
import co.simplon.burger.business.convert.UserConvert;
import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.persistance.repository.conversation.IConversationRepository;

public class ConversationServiceImpl implements IConversationService {
    private IConversationRepository conversationRepository;

    /**
     * Injects the required dependencies to the service.
     * 
     * @param conversationRepository
     */
    public ConversationServiceImpl(final IConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public void saveConversation(final ConversationDto conversation) {
        conversationRepository.save(ConversationConvert.getInstance().toEntity(conversation));
    }

    @Override
    public List<ConversationDto> findByUser(final UserDto user) {
        return ConversationConvert.getInstance()
                .listToDto(conversationRepository.findByUser(UserConvert.getInstance().toEntity(user)));
    }

    @Override
    public void addMessage(final ConversationDto conversation, final MessageDto message) {
        // Check if messages list exists, if not, create it
        List<MessageDto> messages = conversation.getMessages();
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(message);
        conversation.setMessages(messages);
        saveConversation(conversation);
    }

    @Override
    public void addTransaction(final ConversationDto conversation, final TransactionDto transaction) {
        // Check if transactions list exists, if not, create it
        List<TransactionDto> transactions = conversation.getTransactions();
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
        conversation.setTransactions(transactions);
        saveConversation(conversation);
    }
}
