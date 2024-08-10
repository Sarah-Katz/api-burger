package co.simplon.burger.unit.business.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.simplon.burger.business.convert.TransactionConvert;
import co.simplon.burger.business.dto.TransactionDto;
import co.simplon.burger.persistance.entity.Transaction;

class TransactionConvertTest {
    private static TransactionConvert transactionConvert = TransactionConvert.getInstance();

    @Test
    void testToEntity() {
        TransactionDto transactionDto = new TransactionDto();
        Transaction transaction = transactionConvert.toEntity(transactionDto);
        assertEquals(Transaction.class, transaction.getClass());
    }

    @Test
    void testToDto() {
        Transaction transaction = new Transaction();
        TransactionDto transactionDto = transactionConvert.toDto(transaction);
        assertEquals(TransactionDto.class, transactionDto.getClass());
    }

    @Test
    void testToDtoList() {
        List<Transaction> transactions = List.of(new Transaction(), new Transaction());
        List<TransactionDto> transactionDtos = transactionConvert.listToDto(transactions);
        assertEquals(TransactionDto.class, transactionDtos.get(0).getClass());
    }

    @Test
    void testToEntityList() {
        List<TransactionDto> transactionDtos = List.of(new TransactionDto(), new TransactionDto());
        List<Transaction> transactions = transactionConvert.listToEntity(transactionDtos);
        assertEquals(Transaction.class, transactions.get(0).getClass());
    }
}
