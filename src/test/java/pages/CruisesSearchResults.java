package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getWait;

public class CruisesSearchResults extends Cruises {
    @FindBy(xpath = "//div[@id='main-results']")
    private WebElement results;

    public String searchResults() {
        getWait().until(driver -> results.isDisplayed());
        return results.getText();
    }
}
