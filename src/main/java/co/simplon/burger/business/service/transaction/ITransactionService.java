package co.simplon.burger.business.service.transaction;

import java.util.List;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.TransactionDto;

public interface ITransactionService {
    /**
     * Creates or updates a transaction if it exists.
     * 
     * @param transaction The transaction to be saved.
     */
    public void saveTransaction(final TransactionDto transaction);

    /**
     * Finds all transactions related to a given ad.
     * 
     * @param ad The ad to search for.
     * @return a list of transactions related to the given ad.
     */
    public List<TransactionDto> findByAd(final AdDto ad);

    /**
     * Finds all transactions related to a given buyer.
     * 
     * @param idBuyer The id of the buyer to search for.
     * @return a list of transactions related to the given buyer.
     */
    public List<TransactionDto> findByBuyer(final int idBuyer);
}
