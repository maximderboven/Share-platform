package persistence;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;

import java.time.LocalDateTime;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieFactory {
    private static TransactieFactory instance;
    private static TransactieCataloog cataloog;

    private TransactieFactory() {
        synchronized (instance) {
            if (instance != null){
                return;
            }
            instance = this;
        }
        cataloog = new InMemoryTransactieCataloog();
    }

    public static TransactieFactory getInstance() {
        return instance;
    }

    public static TransactieCataloog getCataloog(){
        return cataloog;
    }

    public Transactie maakTransactie(Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime tijdstip){
        int id = cataloog.getNewId();
        Transactie transactie = new Transactie(id , ontvanger, betaler, reservatie, tijdstip);
        return transactie;
    }
}
