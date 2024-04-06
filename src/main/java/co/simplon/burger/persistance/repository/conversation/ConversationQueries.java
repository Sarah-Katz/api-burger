package co.simplon.burger.persistance.repository.conversation;

public class ConversationQueries {
    private ConversationQueries() {
    }

    public static final String FIND_BY_USER = "SELECT c FROM Conversation c WHERE :user MEMBER OF c.users";
}
