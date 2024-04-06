package co.simplon.burger.persistance.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.Transaction;

/**
 * Interface for {@link Transaction} repository.
 */
@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    /**
     * @param ad the ad to search for
     * @return a list of transactions with the given ad
     */
    @Query(TransactionQueries.FIND_BY_AD)
    List<Transaction> findByAd(final Ad ad);

    /**
     * @param idBuyer the id of the buyer to search for
     * @return a list of transactions with the given buyer
     */
    @Query(TransactionQueries.FIND_BY_BUYER)
    List<Transaction> findByBuyer(final int idBuyer);
}
