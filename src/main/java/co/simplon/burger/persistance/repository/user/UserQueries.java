package co.simplon.burger.persistance.repository.user;

public class UserQueries {
    private UserQueries() {
    }

    public static final String FIND_BY_USERNAME = "SELECT u FROM User u WHERE u.username LIKE (:username)";
}
