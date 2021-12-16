package applicatie;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;
import persistence.TransactieCataloog;
import persistence.TransactieFactory;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class TransactieService {
    private static TransactieService instance;
    private static TransactieCataloog cataloog;

    public static TransactieService getInstance() {
        return instance;
    }

    public TransactieService (TransactieCataloog cataloog){
        synchronized (instance){
            if (instance != null) {
                return;
            }
            instance = this;
        }
        TransactieService.cataloog = cataloog;
    }

    public Transactie maakTransactie(Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime datum) {
        return TransactieFactory.getInstance().maakTransactie( ontvanger,  betaler,  reservatie, datum);
    }

    public Transactie geefTransactie(int id){
        return cataloog.get(id);
    }

}
