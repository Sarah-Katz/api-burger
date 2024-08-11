package co.simplon.burger.unit.presentation.controller.transaction;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import co.simplon.burger.business.service.transaction.ITransactionService;
import co.simplon.burger.presentation.controller.transaction.GetTransactionsByAdController;

@ExtendWith(MockitoExtension.class)
class GetTransactionsByAdTest {
    @InjectMocks
    private GetTransactionsByAdController controller;

    @Mock
    private ITransactionService transactionService;

    @Test
    void testGetTransactionsByVendor() {
        final AdDto ad = new AdDto();
        when(transactionService.findByAd(ad)).thenReturn(List.of(new TransactionDto(), new TransactionDto()));
        final List<TransactionDto> transactions = controller.getTransactionsByAd(ad);
        verify(transactionService, times(1)).findByAd(ad);
        assertNotNull(transactions);
    }
}
