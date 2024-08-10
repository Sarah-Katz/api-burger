package co.simplon.burger.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.Transaction;

public class TransactionConvert {
    private static TransactionConvert instance;

    private TransactionConvert() {
    }

    /**
     * @return the transaction converter's instance
     */
    public static TransactionConvert getInstance() {
        if (instance == null) {
            instance = new TransactionConvert();
        }
        return instance;
    }

    /**
     * @param transactionDto the transaction to convert to entity
     * @return the converted entity
     */
    public Transaction toEntity(final TransactionDto transactionDto) {
        final Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getIdTransaction());
        transaction.setPaid(transactionDto.isPaid());
        transaction.setIdBuyer(transactionDto.getIdBuyer());
        transaction.setTransactionDate(transactionDto.getTransactionDate());
        transaction.setReturnDate(transactionDto.getReturnDate());
        transaction.setHasReturned(transactionDto.isHasReturned());
        
        // If there are ads, convert them
        if (transactionDto.getAds()!= null) {
            for (final AdDto ad : transactionDto.getAds()) {
                transaction.getAds().add(AdConvert.getInstance().toEntity(ad));
            }
        }
        return transaction;
    }

    /**
     * @param transaction the transaction to convert to dto
     * @return the converted dto
     */
    public TransactionDto toDto(final Transaction transaction) {
        final TransactionDto transactionDto = new TransactionDto();
        transactionDto.setIdTransaction(transaction.getId());
        transactionDto.setPaid(transaction.isPaid());
        transactionDto.setIdBuyer(transaction.getIdBuyer());
        transactionDto.setTransactionDate(transaction.getTransactionDate());
        transactionDto.setReturnDate(transaction.getReturnDate());
        transactionDto.setHasReturned(transaction.isHasReturned());

        // If there are ads, convert them
        if (transaction.getAds() != null) {
            for (final Ad ad : transaction.getAds()) {
                transactionDto.getAds().add(AdConvert.getInstance().toDto(ad));
            }
        }
        return transactionDto;
    }

    /**
     * @param transactionDtos the transactions to convert to entities
     * @return the converted entities
     */
    public List<Transaction> listToEntity(final List<TransactionDto> transactionDtos) {
        final List<Transaction> transactions = new ArrayList<>();
        for (final TransactionDto transactionDto : transactionDtos) {
            transactions.add(toEntity(transactionDto));
        }
        return transactions;
    }

    /**
     * @param transactions the transactions to convert to dtos
     * @return the converted dtos
     */
    public List<TransactionDto> listToDto(final List<Transaction> transactions) {
        final List<TransactionDto> transactionDtos = new ArrayList<>();
        for (final Transaction transaction : transactions) {
            transactionDtos.add(toDto(transaction));
        }
        return transactionDtos;
    }
}
