package applicatie;

import business.TransactieService;
import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;

import java.time.LocalDateTime;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieController {

    public Transactie maakTransactie (Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime datum){
        return TransactieService.getInstance().maakTransactie( ontvanger,  betaler,  reservatie,  datum);
    }

    public Transactie geefTransactie(int id){
        return TransactieService.getInstance().geefTransactie(id);
    }

}
