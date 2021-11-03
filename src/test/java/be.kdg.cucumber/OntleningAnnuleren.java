package be.kdg.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import model.controllers.ReservationController;
import model.tools.Lendable;
import model.tools.Tool;
import model.tools.ToolType;
import model.users.User;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Derboven
 * @version 1.0 2/11/2021 15:57
 */
public class OntleningAnnuleren {

    Map<String, Lendable> lendableMap = new HashMap<>();
    Map<String, User> userMap = new HashMap<> ();
    Map<String, Reservation> reservationMap = new HashMap<> ();
    ReservationController reservationController;

    @When("{string} aangeeft dat {string} {string} wil ophalen")
    public void aangeeftDatWilOphalen(String huurder, String verhuurder, String reservatie) {
        reservationController.pickUpReservation(reservationMap.get(reservatie));
    }

    @And("{string} aangeeft dat {string} {string} wil annuleren")
    public void aangeeftDatWilAnnuleren(String huurder, String verhuurder, String reservatie) {
        reservationController.cancelReservation (reservationMap.get(reservatie));
    }

    @Then("Er wordt een afhalingtransactie aangemaakt")
    public void erWordtEenAfhalingtransactieAangemaakt() {
        // aanmaken van transactielijnen ?
    }

    @And("Er wordt een transactielijn gemaakt voor de onlening van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorDeOnleningVanMetEenPrijsVanSP(String arg0, int arg1) {
        // aanmaken van transactielijnen ?
    }

    @And("Er wordt een transactielijn gemaakt voor de waarborg van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorDeWaarborgVanMetEenPrijsVanSP(String arg0, int arg1) {
        // aanmaken van transactielijnen ?
    }

    @And("Er wordt een transactielijn gemaakt voor annulatie van {string} met een prijs van {int} SP")
    public void erWordtEenTransactielijnGemaaktVoorAnnulatieVanMetEenPrijsVanSP(String arg0, int arg1) {
        // aanmaken van transactielijnen ?
    }

    @And("heeft {string} {int} SP")
    public void heeftSP(String naam, int aantal) {
        Assert(userMap.get(naam).getSharepoints(),aantal);
    }


    @Given ("Tools")
    public void tools (DataTable table) {
        for (Map<String, String> m : table.asMaps ()) {
            Lendable l = new Tool(m.get ("name"), "", convertType (m.get ("type")), Double.parseDouble (m.get ("sp")));
            lendableMap.put (m.get ("name"), l);
        }
    }

    private ToolType convertType (String str) {
        switch (str) {
            case "Elektrisch":
                return ToolType.ELECTRIC;
            case "Keuken":
                return ToolType.KITCHEN;
            case "Geluid":
                return ToolType.SOUND_INSTALLATION;
            case "Licht":
                return ToolType.LIGHT_INSTALLATION;
        }
        throw new IllegalArgumentException ("Couldn't find tooltype.");
    }

    @Given("Users")
    public void users (DataTable table) {
        for (Map<String, String> m : table.asMaps ()) {
            User user = new User (m.get ("name"), "", "");
            user.addSharepoints (Double.parseDouble (m.get ("sp")));
            userMap.put (m.get ("name"), user);
        }
    }

    @Given ("Reservation")
    public void reservation (DataTable table) {
        for (Map<String, String> m : table.asMaps ()) {
            String name = m.get ("name");
            Reservation r = new Reservation (userMap.get (m.get ("owner")), userMap.get (m.get ("borrower")), lendableMap.get ("lendable"), LocalDate.parse (m.get ("begindate")), Integer.parseInt (m.get ("dayduration")));
        }
    }


}
