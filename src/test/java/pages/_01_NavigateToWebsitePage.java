package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class _01_NavigateToWebsitePage {

    public _01_NavigateToWebsitePage() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(css = "a[title='Hepsiburada']")
    private WebElement mainPageControlText;

    public WebElement getMainPageControlText() {
        return mainPageControlText;
    }
}
