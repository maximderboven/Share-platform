package model.transactions;

import model.tools.Lendable;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class TransactionLine {
    
    private final LocalDateTime time;
    private final Lendable lendable;
    private final TransactionType type;
    
    public TransactionLine(LocalDateTime time, Lendable lendable, TransactionType type) {
        this.time = time;
        this.lendable = lendable;
        this.type = type;
    }
    
    public LocalDateTime getTime () {
        return time;
    }
    
    public Lendable getLendable () {
        return lendable;
    }
    
    public TransactionType getType () {
        return type;
    }
    
    public double getAmount () {
        return type == TransactionType.PICKUP ? lendable.getPrice () + lendable.getGuaranty () : lendable.getGuaranty ();
    }
}
