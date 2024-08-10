package co.simplon.burger.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.service.transaction.TransactionServiceImpl;
import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.Transaction;
import co.simplon.burger.persistance.repository.transaction.ITransactionRepository;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @InjectMocks
    TransactionServiceImpl transactionService;

    @Mock
    ITransactionRepository transactionRepository;

    @Test
    void testSaveTransaction() {
        TransactionDto transactionDto = new TransactionDto();
        when(transactionRepository.save(any(Transaction.class))).thenReturn(null);
        transactionService.saveTransaction(transactionDto);

        // Verify that the save method was called once
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    void testGetTransactionsByAd() {
        AdDto adDto = new AdDto();
        when(transactionRepository.findByAd(any(Ad.class))).thenReturn(List.of(new Transaction(), new Transaction()));
        List<TransactionDto> transactions = transactionService.findByAd(adDto);

        // Verify that the findByAd method was called once
        verify(transactionRepository, times(1)).findByAd(any(Ad.class));
        assertTrue(!transactions.isEmpty());
    }

    @Test
    void testGetTransactionsByBuyer() {
        int idBuyer = 1;
        when(transactionRepository.findByBuyer(idBuyer)).thenReturn(List.of(new Transaction(), new Transaction()));
        List<TransactionDto> transactions = transactionService.findByBuyer(idBuyer);

        // Verify that the findByBuyer method was called once
        verify(transactionRepository, times(1)).findByBuyer(idBuyer);
        assertTrue(!transactions.isEmpty());
    }
}
