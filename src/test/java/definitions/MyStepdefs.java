package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;


public class MyStepdefs {
    MainPage startPage = new MainPage();
    Flights tabFlights = new Flights();
    OneWayFlights flightType = new OneWayFlights();
    Cars tabCars = new Cars();
    AirportTransportation pTransportation = new AirportTransportation();
    Cruises tabCruises = new Cruises();

    @Given("I open home page")
    public void iOpenHomePage() {
        startPage.open();
    }

    @When("I click tab {string}")
    public void iClickTab(String tab) {
        startPage.clickNavigationTab(tab);
    }

    @And("I click flight option {string}")
    public void iClickFlightOption(String tab) {
        tabFlights.clickFlightType(tab);
    }

    @And("I enter {string} into field {string}")
    public void iEnterIntoField(String city, String direction) {
        switch (direction){
            case "Leaving from":
                flightType.setOrigin(city);
                break;
            case "Going to":
                flightType.setDestination(city);
                break;
            default:
                System.out.println("not such field avalable");
        }
    }

    @And("I set {string} {string} into {string}")
    public void iSetInto(String month, String date, String direction) {
        switch (direction){
            case "Departing day":
                flightType.setDepartingDate(month, date);
                break;
            case "Returning":
                flightType.setReturningDate(month, date);
                break;
            default:
                System.out.println("not such field avalable");
        }
    }

    @And("I click search")
    public void iClickSearch() {
        flightType.clickSearch();
    }

    @Then("i see results contains {string}")
    public void iSeeResultsContains(String expectedData) {
        assertThat(new FlightsResults().searchResults().contains(expectedData));
    }

    @Then("^I wait for (\\d+) sec$")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @And("I click car option {string}")
    public void iClickCarOption(String type) {
        tabCars.setTypeTransportation(type);

    }

    @And("I enter location for {string} into field {string}")
    public void iEnterLocationForIntoField(String location, String fieldsName) {
        switch (fieldsName){
            case "Airport":
                pTransportation.setLocation(location);
                break;
            case "Hotel name":
                pTransportation.setHotel(location);
                break;
            default:
                System.out.println("wrong location");
        }
    }

    @And("I set {string} {string} into field Flight arrival date")
    public void iSetIntoFieldFlightArrivalDate(String month, String date) {
        pTransportation.setArrivalDate(month, date);
    }

    @And("I select {string} for field Flight arrival time")
    public void iSelectForFieldFlightArrivalTime(String time) {
        pTransportation.setTime(time);
    }

    @And("I click search transportation")
    public void iClickSearchTransportation() {
        pTransportation.clickSearch();
    }

    @Then("i see car search results contains {string}")
    public void iSeeCarSearchResultsContains(String expectedData) {
        assertThat(new CarSearchResults().searchResults().contains(expectedData));
    }

    @And("I select {string} from field Going to")
    public void iSelectFromFieldGoingTo(String place) {
        tabCruises.setGoingTo(place);
    }

    @And("I set {string} {string} into field {string}")
    public void iSetIntoField(String month, String date, String field) {
        tabCruises.setDeparts(field, month, date);
    }

    @And("I click search cruises")
    public void iClickSearchCruises() {
        tabCruises.clickSearch();
    }

    @Then("i see cruises search results contains {string}")
    public void iSeeCruisesSearchResultsContains(String expected) {
        assertThat(new CruisesSearchResults().searchResults().contains(expected));
    }
}
