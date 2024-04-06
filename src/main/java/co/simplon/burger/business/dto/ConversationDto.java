package co.simplon.burger.business.dto;

import java.util.List;

public class ConversationDto {
    private int idConversation;
    private List<UserDto> users;
    private List<MessageDto> messages;
    private List<TransactionDto> transactions;

    /**
     * @return the idConversation
     */
    public int getIdConversation() {
        return idConversation;
    }

    /**
     * @param idConversation the idConversation to set
     */
    public void setIdConversation(final int idConversation) {
        this.idConversation = idConversation;
    }

    /**
     * @return the users
     */
    public List<UserDto> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(final List<UserDto> users) {
        this.users = users;
    }

    /**
     * @return the messages
     */
    public List<MessageDto> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(final List<MessageDto> messages) {
        this.messages = messages;
    }

    /**
     * @return the transactions
     */
    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(final List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
