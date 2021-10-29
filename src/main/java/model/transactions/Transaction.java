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
    
    private final TransactionLines transactionLines = new TransactionLines ();

    private void addLine(LocalDateTime time, Lendable lendable) {
        transactionLines.add (new TransactionLine (time, lendable));
    }
}
