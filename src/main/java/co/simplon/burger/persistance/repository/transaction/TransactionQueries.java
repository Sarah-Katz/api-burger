package co.simplon.burger.persistance.repository.transaction;

public class TransactionQueries {
    private TransactionQueries() {
    }

    public static final String FIND_BY_AD = "SELECT t FROM Transaction t WHERE :ad MEMBER OF t.ads";
    public static final String FIND_BY_BUYER = "SELECT t FROM Transaction t WHERE t.idBuyer = :idBuyer";
}
