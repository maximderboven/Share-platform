package model.transactions;

import model.tools.Lendable;
import repositories.MultiClass;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class Transaction {
    private LocalDateTime time;
    private Lendable lendable;
    private double amount;
    private final MultiClass<TransactionLine> transactionLines = new MultiClass<> ();
    
    public MultiClass<TransactionLine> getTransactionLines () {
        return transactionLines;
    }
}
