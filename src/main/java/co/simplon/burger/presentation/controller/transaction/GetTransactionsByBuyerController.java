package co.simplon.burger.presentation.controller.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.transaction.ITransactionService;

@RestController
@CrossOrigin
public class GetTransactionsByBuyerController {
    private final ITransactionService transactionService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param transactionService
     */
    public GetTransactionsByBuyerController(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Returns all transactions for a specific vendor.
     * 
     * @param id the id of the {@link UserDto} who owns the transactions
     */
    @GetMapping("/transactions/byBuyer/{id}")
    public List<TransactionDto> getTransactionsByBuyer(@PathVariable final int id) {
        return transactionService.findByBuyer(id);
    }
}
