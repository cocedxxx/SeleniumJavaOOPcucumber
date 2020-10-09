package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public abstract class Page {
    protected String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public void waitingToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitingNotToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitingToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickSafe(WebElement element) {
        waitingToBeClickable(element);
        try {
            element.click();
        }catch (ElementClickInterceptedException e) {
            getExecuter().executeScript("arguments[0].click()", element);
        }
    }

    public void sendKeysSafe(WebElement into, String value){
        waitingToBeVisible(into);
        String currentValue = into.getAttribute("value");
        if(!currentValue.isEmpty()){
            into.clear();
        }
        into.sendKeys(value);
    }

}
