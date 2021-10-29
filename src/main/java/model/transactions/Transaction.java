package model.transactions;

import model.Lendable;
import repositories.MultiClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class Transaction {
    private LocalDateTime time;
    private Lendable lendable;
    private double amount;
    private final MultiClass<TransactionLine> transactionLines = new MultiClass<> ();
    
    private void addLine(LocalDateTime time, Lendable lendable) {
        transactionLines.add (new TransactionLine (time, lendable));
    }
    
    public MultiClass<TransactionLine> getTransactionLines () {
        return transactionLines;
    }
}
