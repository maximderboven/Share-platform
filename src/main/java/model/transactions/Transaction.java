package model.transactions;

import model.tools.Lendable;
import model.tools.Tool;
import repositories.MultiClass;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class Transaction {
    private final MultiClass<TransactionLine> transactionLines = new MultiClass<> ();
    
    
    public MultiClass<TransactionLine> getTransactionLines () {
        return transactionLines;
    }
    
    public void generatePickupTransactionLinesForLendable (Lendable lendable) {
        generateTransactionLines (TransactionType.PICKUP, lendable);
    }
    
    public void generateReturnTransactionLinesForLendable (Lendable lendable) {
        generateTransactionLines (TransactionType.RETURN, lendable);
    }
    
    private void generateTransactionLines (TransactionType type, Lendable lendable) {
        // Remove all Transaction lines of given TransactionType
        for (TransactionLine line : transactionLines.getAll ())
            if (line.getType () == type)
                transactionLines.remove (line);
        // (Re)add all transaction lines for lendable
        for (Tool tool : lendable.getAllTools ()) {
            TransactionLine line = new TransactionLine (LocalDateTime.now (), tool, type);
            transactionLines.add (line);
        }
    }
}
