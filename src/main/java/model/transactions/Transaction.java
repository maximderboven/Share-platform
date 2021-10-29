package model.transactions;

import model.Lendable;

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
    private final TransactionLines transactionLines;

    public Transaction() {
        transactionLines = new TransactionLines ();
    }

    private void addLine(LocalDateTime time, Lendable lendable) {
        transactionLines.add (new TransactionLine (time, lendable));
    }
    
    public TransactionLines getTransactionLines () {
        return transactionLines;
    }
}
