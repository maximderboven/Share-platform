package util;

import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Maxim Derboven
 * @version 1.0 21/11/2021 15:32
 */
public class Periode {
    private LocalDate van;
    private LocalDate tot;
    
    public Periode (LocalDate van, LocalDate tot) {
        setVan (van);
        setTot (tot);
    }
    
    public int getDays () {
        return (int) (Duration.between (van, tot).getSeconds () / 86400);
    }
    
    public LocalDate getVan () {
        return van;
    }
    
    public void setVan (LocalDate van) {
        this.van = van;
    }
    
    public LocalDate getTot () {
        return tot;
    }
    
    public void setTot (LocalDate tot) {
        this.tot = tot;
    }
    
    public boolean isIn (LocalDate datum) {
        return !datum.isBefore (van) && !datum.isAfter (tot);
    }
}
