package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Flights extends MainPage {
    @FindBy(xpath = "//div[@id='location-field-leg1-origin-menu']//div[2]//input")
    private WebElement inputFrom;

    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    private WebElement buttonFrom;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    private WebElement buttonGoingTo;

    @FindBy(xpath = "//div[@id='location-field-leg1-destination-menu']//div[2]//input")
    private WebElement inputGoingTo;

    @FindBy(xpath = "//div[@id='location-field-leg1-origin-menu']//div//ul//li[1]//button[1]")
    private WebElement originResult;

    @FindBy(xpath = "//div[@id='location-field-leg1-destination-menu']//div//ul//li[1]//button[1]")
    private WebElement destinationResult;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement buttonSearch;

    @FindBy(xpath = "//button[@id='d1-btn']")
    private WebElement buttonDepartingDate;

    @FindBy(xpath = "//span[contains(text(),'Done')]/..")
    private WebElement buttonDone;

// dynamic xpath for all tab options
    private WebElement flightsTypesTab(String tabOption){
        return getDriver().findElement(By.xpath("//*[@role = 'tablist']//*[contains(text(),'"+ tabOption +"')]"));
    }
    private WebElement datePicker(String month, String date){
        return getDriver().findElement(By.xpath("//div[@class='uitk-calendar']//*[contains(text(),'"+ month +"')]//..//button[@data-day='"+ date +"']"));
    }

    //Methods
    public void clickFlightType(String type){
        flightsTypesTab(type).click();
    }

    public void setOrigin(String cityName) {
        buttonFrom.click();
        waitingToBeClickable(inputFrom);
        inputFrom.sendKeys(cityName);
        waitingToBeClickable(originResult);
        originResult.click();
    }
    public void setDestination(String cityName){
        buttonGoingTo.click();
        waitingToBeClickable(inputGoingTo);
        inputGoingTo.sendKeys(cityName);
        waitingToBeClickable(destinationResult);
        destinationResult.click();
    }

    public void setDepartingDate(String month, String date){
        waitingToBeClickable(buttonDepartingDate);
        buttonDepartingDate.click();
        waitingToBeClickable(datePicker(month, date));
        datePicker(month, date).click();
        buttonDone.click();
    }
    public void setReturningDate(String month, String date){
        //not applied
//        buttonDepartingDate.click();
//        datePicker(month, date).click();
//        buttonDone.click();
    }

    public void clickSearch(){
        buttonSearch.click();
    }

}
