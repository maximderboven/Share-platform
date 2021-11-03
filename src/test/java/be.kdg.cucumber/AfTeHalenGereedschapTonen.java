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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Derboven
 * @version 1.0 2/11/2021 15:33
 */
public class AfTeHalenGereedschapTonen {
    
    Map<String, Lendable> lendableMap = new HashMap<> ();
    Map<String, User> userMap = new HashMap<> ();
    Map<String, Reservation> reservationMap = new HashMap<> ();
    ReservationController reservationController;
    
    LocalDate today;
    
    @Given ("today is {string}")
    public void todayIs (String waarde) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        today = LocalDate.parse (waarde, formatter);
        
    }

    @When("{string} aangeeft dat {string} zijn reservaties wil ophalen")
    public void aangeeftDatZijnReservatiesWilOphalen(String huurder, String verhuurder) {
        reservationController.getReservationsForOwnerAndBorrower(verhuurder, huurder);
    }
    
    @Then ("wordt een lijst met {int} reservaties getoond")
    public void wordtEenLijstMetReservatiesGetoond (int arg0) {
        reservationController.getReservationsForOwnerAndBorrower().size();
    }
    
    @And ("bevat de lijst {string}")
    public void bevatDeLijst (String arg0) {
        //assert(verhuurder.getReservaties().stream().anyMatch(item -> "foo".equals(item.getName()));
    }

    @Given ("Tools")
    public void tools (DataTable table) {
        for (Map<String, String> m : table.asMaps ()) {
            Lendable l = new Tool (m.get ("name"), "", convertType (m.get ("type")), Double.parseDouble (m.get ("sp")));
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
    
    @Given ("Users")
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
