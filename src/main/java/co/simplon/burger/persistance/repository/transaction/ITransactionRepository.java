package co.simplon.burger.persistance.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(TransactionQueries.FIND_BY_AD)
    List<Transaction> findByAd(final Ad ad);

    @Query(TransactionQueries.FIND_BY_BUYER)
    List<Transaction> findByBuyer(final int idBuyer);
}
