package util;

import java.time.LocalDate;

/**
 * @author Maxim Derboven
 * @version 1.0 21/11/2021 15:32
 */
public class Periode {
    LocalDate van;
    LocalDate tot;

    public Periode(LocalDate van, LocalDate tot) {
        setVan(van);
        setTot(tot);
    }

    public LocalDate getVan() {
        return van;
    }

    public void setVan(LocalDate van) {
        if (van == null || van.isBefore(LocalDate.now()))
            throw new IllegalArgumentException ("Startdate can not be in the past");
        this.van = van;
    }

    public LocalDate getTot() {
        return tot;
    }

    public void setTot(LocalDate tot) {
        if (tot == null || tot.isBefore(LocalDate.now()))
            throw new IllegalArgumentException ("Enddate can not be in the past");
        this.tot = tot;
    }
}
