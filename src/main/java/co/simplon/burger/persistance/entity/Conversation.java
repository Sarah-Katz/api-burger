package co.simplon.burger.persistance.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conversation")
    private int idConversation;

    @ManyToMany
    @JoinTable(name = "conversation_user", joinColumns = @JoinColumn(name = "id_conversation"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    @OneToMany
    private List<Message> messages;

    @OneToMany
    private List<Transaction> transactions;

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
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(final List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(final List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
