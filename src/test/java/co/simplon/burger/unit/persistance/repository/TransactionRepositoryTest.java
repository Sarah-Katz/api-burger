package co.simplon.burger.unit.persistance.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.persistance.entity.Ad;
import co.simplon.burger.persistance.entity.Transaction;
import co.simplon.burger.persistance.repository.transaction.ITransactionRepository;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {
    @Mock
    private ITransactionRepository transactionRepository;

    @Test
    void testQueryTransactionsByAd() {
        final Ad user = new Ad();
        when(transactionRepository.findByAd(user)).thenReturn(List.of(new Transaction(), new Transaction()));
        final List<Transaction> transactions = transactionRepository.findByAd(user);
        verify(transactionRepository, times(1)).findByAd(user);
        assert transactions != null;
    }

    @Test
    void testQueryTransactionsByBuyer() {
        final int buyerId = 1;
        when(transactionRepository.findByBuyer(buyerId)).thenReturn(List.of(new Transaction(), new Transaction()));
        final List<Transaction> transactions = transactionRepository.findByBuyer(buyerId);
        verify(transactionRepository, times(1)).findByBuyer(buyerId);
        assert transactions != null;
    }
}
