package be.kdg.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import model.controllers.ReservationController;
import model.users.User;

/**
 * @author Maxim Derboven
 * @version 1.0 2/11/2021 15:57
 */
public class OntleningAnnuleren {

    User huurder;
    User verhuurder;
    Reservation reservatie;
    ReservationController reservationController;

    @When("{string} aangeeft dat {string} {string} wil ophalen")
    public void aangeeftDatWilOphalen(String huurder, String verhuurder, String reservatie) {
        this.huurder = new User (huurder, "blabla", "Groenplaats 50");
        this.verhuurder = new User (verhuurder, "vdb", "Maanstraat 18");
        reservationController.pickUpReservation (reservatie);
    }

    @And("{string} aangeeft dat {string} {string} wil annuleren")
    public void aangeeftDatWilAnnuleren(String huurder, String verhuurder, String reservatie) {
        reservationController.cancelReservation (reservatie);
    }

    @Then("Er wordt een afhalingtransactie aangemaakt")
    public void erWordtEenAfhalingtransactieAangemaakt() {
        reservationController.pickUpReservation ();
    }

    @And("Er wordt een transactielijn gemaakt voor de onlening van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorDeOnleningVanMetEenPrijsVanSP(String arg0, int arg1) {
        reservatie.getOwner().CreateTransaction();
    }

    @And("Er wordt een transactielijn gemaakt voor de waarborg van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorDeWaarborgVanMetEenPrijsVanSP(String arg0, int arg1) {
        //same
    }

    @And("Er wordt een transactielijn gemaakt voor annulatie van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorAnnulatieVanMetEenPrijsVanSP(String arg0, int arg1) {
        huurder.removeSharepoints(40);
    }

    @And("heeft {string} {int} SP")
    public void heeftSP(String arg0, int arg1) {
        Assert(huurder.getSharepoints(),arg1);
    }


}
