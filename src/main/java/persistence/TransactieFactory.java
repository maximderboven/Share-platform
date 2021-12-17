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
    private Cataloog<? extends Number, Transactie> cataloog;

    public TransactieFactory(Cataloog<? extends Number, Transactie> cataloog) {
        synchronized (instance) {
            if (instance != null){
                return;
            }
            instance = this;
        }
        this.cataloog = cataloog;
    }

    public static TransactieFactory getInstance() {
        return instance;
    }

    public Cataloog<? extends Number, Transactie> getCataloog(){
        return cataloog;
    }
}
