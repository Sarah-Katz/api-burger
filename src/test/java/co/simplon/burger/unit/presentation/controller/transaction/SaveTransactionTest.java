package co.simplon.burger.unit.presentation.controller.transaction;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.service.transaction.ITransactionService;
import co.simplon.burger.presentation.controller.transaction.SaveTransactionController;

@ExtendWith(MockitoExtension.class)
class SaveTransactionTest {
    @InjectMocks
    private SaveTransactionController saveTransactionController;

    @Mock
    private ITransactionService transactionService;

    @Test
    void testSaveTransaction() {
        final TransactionDto transactionDto = new TransactionDto();
        doNothing().when(transactionService).saveTransaction(transactionDto);
        saveTransactionController.saveTransaction(transactionDto);
        verify(transactionService, times(1)).saveTransaction(transactionDto);
    }
}
