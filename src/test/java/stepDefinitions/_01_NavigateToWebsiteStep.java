package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages._01_NavigateToWebsitePage;
import pages.Parent;
import utilities.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _01_NavigateToWebsiteStep extends Parent {

    private final _01_NavigateToWebsitePage nwp;

    public _01_NavigateToWebsiteStep(_01_NavigateToWebsitePage nwp) {
        this.nwp=nwp;
    }

    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        WebDriver driver= BaseDriver.getDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Then("^Validation of the website$")
    public void validationOfTheWebsite() {

        verifyElementDisplayed(nwp.getMainPageControlText());
    }
}
