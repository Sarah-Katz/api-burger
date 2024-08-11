package co.simplon.burger.presentation.controller.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.AdDto;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.business.service.transaction.ITransactionService;

@RestController
@CrossOrigin
public class GetTransactionsByAdController {
    private final ITransactionService transactionService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param transactionService
     */
    public GetTransactionsByAdController(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Returns all transactions for a specific vendor.
     * 
     * @param ad the {@link AdDto} who owns the transactions
     */
    @GetMapping("/transactions/byAd")
    public List<TransactionDto> getTransactionsByAd(@RequestBody final AdDto ad) {
        return transactionService.findByAd(ad);
    }
}
