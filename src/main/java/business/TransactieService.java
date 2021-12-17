package business;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;
import persistence.Cataloog;
import persistence.TransactieCataloog;
import persistence.TransactieFactory;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class TransactieService {
    private static TransactieService instance;
    private Cataloog<Long, Transactie> cataloog;

    public static TransactieService getInstance() {
        return instance;
    }

    public TransactieService (Cataloog<Long, Transactie> cataloog){
        synchronized (instance){
            if (instance != null) {
                return;
            }
            instance = this;
        }
        this.cataloog = cataloog;
    }

    public Transactie geefTransactie(Long id){
        return cataloog.get(id);
    }

}
