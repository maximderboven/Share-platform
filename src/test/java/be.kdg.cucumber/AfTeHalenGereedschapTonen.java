package be.kdg.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.users.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Maxim Derboven
 * @version 1.0 2/11/2021 15:33
 */
public class AfTeHalenGereedschapTonen {

    LocalDate today;
    User huurder;
    User verhuurder;

    @Given("today is {string}")
    public void todayIs(String waarde) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        today = LocalDate.parse(waarde, formatter);

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
