package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getWait;

public class FlightsResults extends Flights {

    @FindBy(xpath = "//*[@id='flightModuleList']")
    private WebElement results;

    public String searchResults() {
        getWait(10).until(driver -> results.isDisplayed());
        return results.getText();
    }
}
