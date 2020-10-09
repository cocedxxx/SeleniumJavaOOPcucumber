package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Cars extends MainPage {
    //Properties
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement buttonSearch;


    private WebElement carOptions(String option){
        return getDriver().findElement(By.xpath("//span[contains(text(),'"+ option +"')]/.."));
    }

    //Methods

    public void setTypeTransportation(String type){
        carOptions(type).click();
    }

    public void clickSearch(){
        buttonSearch.click();
    }
}
