package co.simplon.burger.business.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.burger.business.convert.AdConvert;
import co.simplon.burger.business.convert.TransactionConvert;
import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.persistance.repository.transaction.ITransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
    private ITransactionRepository transactionRepository;

    /**
     * Injects the required dependencies to the service.
     * 
     * @param transactionRepository
     */
    public TransactionServiceImpl(final ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void saveTransaction(final TransactionDto transaction) {
        transactionRepository.save(TransactionConvert.getInstance().toEntity(transaction));
    }

    @Override
    public List<TransactionDto> findByAd(final AdDto ad) {
        return TransactionConvert.getInstance()
                .listToDto(transactionRepository.findByAd(AdConvert.getInstance().toEntity(ad)));
    }

    @Override
    public List<TransactionDto> findByBuyer(final int idBuyer) {
        return TransactionConvert.getInstance().listToDto(transactionRepository.findByBuyer(idBuyer));
    }
}