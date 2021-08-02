package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseDriver;

import java.util.List;

public class Parent {


    WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
    JavascriptExecutor js= (JavascriptExecutor) BaseDriver.getDriver();
    Actions actions=new Actions(BaseDriver.getDriver());

    public void waitUntilVisible(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element){

        js.executeScript("arguments[0].scrollIntoView()",element);
    }

    public void clickFunction(WebElement element){

        scrollToElement(element);
        waitUntilClickable(element);
        try {
            element.click();
        }catch (Exception e){
            js.executeScript("arguments[0].click();",element);
        }
    }

    public void sendKeysFunction(WebElement element, String value){

        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void verifyContainsText(WebElement element, String text){

        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void compareTwoWebElementsTexts(WebElement element1, WebElement element2){

        Assert.assertTrue(element1.getText().toLowerCase().contains(element2.getText().toLowerCase()));
    }

    public void verifyElementDisplayed(WebElement element){

        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void moveToElement(WebElement element){
        waitUntilVisible(element);
        Action action=actions.moveToElement(element).click().build();
        action.perform();
    }

    public void alertDismiss(){

        BaseDriver.getDriver().switchTo().alert().dismiss();
    }

    public void scrollToTop(){

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void verifyListContainsText(List<WebElement> elementList, String text){

        for (WebElement e :elementList)
        {
            waitUntilVisible(e);
            Assert.assertTrue(e.getText().toLowerCase().contains(text.toLowerCase()));
        }
    }

    public void waitForStaleElement(WebElement element){

        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void urlContains(String value, WebDriver driver){

        Assert.assertTrue(driver.getCurrentUrl().contains(value));
    }




}
