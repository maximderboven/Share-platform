package be.kdg.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tools.Tool;
import model.tools.ToolType;
import model.users.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Maxim Derboven
 * @version 1.0 2/11/2021 15:33
 */
public class AfTeHalenGereedschapTonen {
    
    User eveline, diederik;
    
    public AfTeHalenGereedschapTonen () {
        configureTestData ();
    }
    
    public void configureTestData () {
        
        eveline = new User ("Eveline", "", "");
        eveline.addSharepoints (1000);
        diederik = new User ("Diederik", "", "");
        diederik.addSharepoints (1000);
        
        eveline.getLendables ().add (new Tool ("Kettingzaag", "", ToolType.ELECTRIC, 10));
        eveline.getLendables ().add (new Tool ("Kettingzaag2", "", ToolType.ELECTRIC, 10));
        eveline.getLendables ().add (new Tool ("Klopboormachine", "", ToolType.ELECTRIC, 20));
        eveline.getLendables ().add (new Tool ("Keukenrobot", "", ToolType.KITCHEN, 15));
        
        diederik.getLendables ().add (new Tool ("PA Seismic", "", ToolType.SOUND_INSTALLATION, 200));
        diederik.getLendables ().add (new Tool ("Black Strobo Magic", "", ToolType.LIGHT_INSTALLATION, 50));
        
        
    }
    
    LocalDate today;
    
    @Given ("today is {string}")
    public void todayIs (String waarde) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        today = LocalDate.parse (waarde, formatter);
        
    }

    @When("{string} aangeeft dat {string} zijn reservaties wil ophalen")
    public void aangeeftDatZijnReservatiesWilOphalen(String huurder, String verhuurder) {
        this.huurder = new User(huurder);
        this.verhuurder = new User(verhuurder);
        verhuurder.getReservatie();
    }

    @Then("wordt een lijst met {int} reservaties getoond")
    public void wordtEenLijstMetReservatiesGetoond(int arg0) {
        // huh ?
    }

    @And("bevat de lijst {string}")
    public void bevatDeLijst(String arg0) {
        //assert(verhuurder.getReservaties().stream().anyMatch(item -> "foo".equals(item.getName()));
    }


}
