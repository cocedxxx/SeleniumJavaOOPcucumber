package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class Cruises extends MainPage{
//properties
    @FindBy(xpath = "//select[@id='cruise-destination']")
    private WebElement selectDestination;

    @FindBy(xpath = "//span[contains(text(),'Done')]/..")
    private WebElement buttonDone;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement buttonSearch;

    private WebElement departs(String fieldOption){
        return getDriver().findElement(By.xpath("//input[@placeholder='"+ fieldOption +"']/.."));
    }

    private WebElement datePicker(String month, String date){
        return getDriver().findElement(By.xpath("//div[@class='uitk-calendar']//*[contains(text(),'"+ month +"')]//..//button[@data-day='"+ date +"']"));
    }

//Methods

    public void setGoingTo(String place){
        new Select(selectDestination).selectByVisibleText(place);
    }

    public void setDeparts(String fields, String month, String date ){
        clickSafe(departs(fields));
        waitingToBeClickable(datePicker(month, date));
        datePicker(month, date).click();
        buttonDone.click();
    }

    public void clickSearch(){
        buttonSearch.click();
    }
}
