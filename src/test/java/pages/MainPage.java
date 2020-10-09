package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class MainPage extends Page {

    public MainPage(){
        url = "https://www.expedia.com/";
    }

    private WebElement tabList(String tabOption){
        return getDriver().findElement(By.xpath("//*[@role = 'tablist']//*[contains(text(),'"+ tabOption +"')]"));
    }

    public void clickNavigationTab(String nameTab){
//        tabList(nameTab).click();
        clickSafe(tabList(nameTab));
    }


}
