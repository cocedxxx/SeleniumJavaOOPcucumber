package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class AirportTransportation extends Cars{
    //Properties
    @FindBy(xpath = "//button[contains(text(),'travelers')]")
    private WebElement buttonTravelers;

    @FindBy(xpath = "//span[contains(text(),'Airport')]/..//button")
        private WebElement buttonAirport;

    @FindBy(xpath = "//input[@id='location-field-location']")
        private WebElement inputAirport;

    @FindBy(xpath = "//div[@id='location-field-location-menu']//li[1]//button[1]")
    private WebElement selectCarResult;

    @FindBy(xpath = "//span[contains(text(),'Hotel name')]/..//button")
        private WebElement buttonHotel;

    @FindBy(xpath = "//input[@id='location-field-hotelName']")
        private WebElement inputHotel;

    @FindBy(xpath = "//div[@id='location-field-hotelName-menu']//li[1]//button[1]")
    private WebElement selectHotResult;

    @FindBy(xpath = "//button[@id='d1-btn']")
        private WebElement datePikerFlightArrivalDate;

    @FindBy(xpath = "//select[@aria-label='Flight arrival time']")
        private WebElement selectTime;

    @FindBy(xpath = "//span[contains(text(),'Done')]/..")
    private WebElement buttonDone;

    private WebElement datePicker(String month, String date){
        return getDriver().findElement(By.xpath("//div[@class='uitk-calendar']//*[contains(text(),'"+ month +"')]//..//button[@data-day='"+ date +"']"));
    }

    private WebElement field(String fieldOption){
        return getDriver().findElement(By.xpath("//span[contains(text(),'"+ fieldOption +"')]/..//button"));
    }

    public void setLocation(String cityName) {
        buttonAirport.click();
        waitingToBeClickable(inputAirport);
        inputAirport.sendKeys(cityName);
        waitingToBeClickable(selectCarResult);
        selectCarResult.click();
    }
    public void setHotel(String hotelName){
        buttonHotel.click();
        waitingToBeClickable(inputHotel);
        inputHotel.sendKeys(hotelName);
        waitingToBeClickable(selectHotResult);
        selectHotResult.click();
    }

    public void setArrivalDate(String month, String date){
        datePikerFlightArrivalDate.click();
        waitingToBeClickable(datePicker(month,date));
        datePicker(month, date).click();
        buttonDone.click();
    }

    public void setTime(String time){
        new Select(selectTime).selectByVisibleText(time);
    }
}
