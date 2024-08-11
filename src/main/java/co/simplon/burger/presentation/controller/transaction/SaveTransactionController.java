package co.simplon.burger.presentation.controller.transaction;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.service.transaction.ITransactionService;

@RestController
@CrossOrigin
public class SaveTransactionController {
    private final ITransactionService transactionService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param transactionService
     */
    public SaveTransactionController(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Creates or updates an Transaction if it already exists.
     * 
     * @param Transaction the {@link TransactionDto} to be saved
     */
    @PostMapping("/transactions")
    public void saveTransaction(@RequestBody final TransactionDto transaction) {
        transactionService.saveTransaction(transaction);
    }
}
