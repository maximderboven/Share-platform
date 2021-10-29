package model.transactions;

import model.Lendable;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class TransactionLine {
    private Lendable lendable;
    private double amount;
    private LocalDateTime time;

    public TransactionLine(Lendable lendable, double amount, LocalDateTime time) {
        this.lendable = lendable;
        this.amount = amount;
        this.time = time;
    }
}
