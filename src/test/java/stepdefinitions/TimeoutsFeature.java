package stepdefinitions;

import com.tomakehurst.crashlab.saboteur.Saboteur;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import static com.tomakehurst.crashlab.saboteur.Delay.delay;
import static com.tomakehurst.crashlab.saboteur.PacketLoss.packetLoss;

public class TimeoutsFeature {

    private Saboteur saboteur;

    @Given("^I can control the network between the application and its dependency$")
    public void I_can_control_the_network_between_the_application_and_its_dependency() throws Throwable {
        saboteur = Saboteur.defineClient("cucumber", 8080, "192.168.2.2");
    }

    @Given("^the network between my application and its dependency is dropping all traffic$")
    public void the_network_between_my_application_and_its_dependency_is_dropping_all_traffic() throws Throwable {
        saboteur.addFault(packetLoss("all traffic").probability(100.0));
    }

    @When("^I make a request to my application$")
    public void I_make_a_request_to_my_application() throws Throwable {
    }

    @Then("^my application times out$")
    public void my_application_times_out() throws Throwable {
    }

    @Given("^the network between my application and its dependency is slow$")
    public void the_network_between_my_application_and_its_dependency_is_slow() throws Throwable {
        saboteur.addFault(delay("all traffic").delay(400, TimeUnit.MILLISECONDS));
    }
}
