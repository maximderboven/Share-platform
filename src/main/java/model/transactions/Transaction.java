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
    private final List<TransactionLine> transactionLines;

    public Transaction() {
        transactionLines = new ArrayList<>();
    }

    private void addLine(LocalDateTime time, Lendable lendable, double amount) {
        this.time = time;
        this.lendable = lendable;
        this.amount = amount;
    }

    private List<TransactionLine> getAllTransactionLines(){
        return new ArrayList<>(transactionLines);
    }

    private void removeTransaction(Transaction transaction) {
        getAllTransactionLines().remove(transaction);
    }
}
