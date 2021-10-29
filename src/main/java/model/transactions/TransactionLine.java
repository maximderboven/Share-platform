package model.transactions;

import model.tools.Lendable;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class TransactionLine {
    
    private LocalDateTime time;
    private Lendable lendable;
    
    public TransactionLine(LocalDateTime time, Lendable lendable) {
        this.time = time;
        this.lendable = lendable;
    }
    
    public LocalDateTime getTime () {
        return time;
    }
    
    public Lendable getLendable () {
        return lendable;
    }
    
    public double getAmount () {
        return lendable.getPrice ();
    }
}
