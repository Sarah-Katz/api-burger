package co.simplon.burger.persistance.repository.ad;

public class AdQueries {
    private AdQueries() {
    }

    public static final String FIND_BY_VENDOR = "SELECT a FROM Ad a WHERE a.vendor = (:vendor)";
}
