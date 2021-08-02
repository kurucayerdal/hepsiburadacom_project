package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages._02_LoginPage;
import pages.Parent;
import utilities.ExcelUtility;

import java.util.List;

public class _02_LoginStep extends Parent {

    private final _02_LoginPage lp;

    public _02_LoginStep(_02_LoginPage lp) {
        this.lp = lp;
    }

    @Given("^User should login with a valid username and password$")
    public void userShouldLoginWithAValidUsernameAndPassword() {

        scrollToTop();
        moveToElement(lp.getTextLogin());
        clickFunction(lp.getButtonLoginMainPage());

        List<List<String>> dataList = ExcelUtility.
                getListData("src/test/java/resources/hepsiBurada.xlsx", "Sayfa1", 2);
        sendKeysFunction(lp.getInputEmail(), dataList.get(0).get(0));
        sendKeysFunction(lp.getInputPassword(), dataList.get(0).get(1));
        clickFunction(lp.getButtonLogin());
    }

    @Then("^Verify that user could login successfully$")
    public void verifyThatUserCouldLoginSuccessfully() {

        verifyElementDisplayed(lp.getTextLoginVerification());
    }


}
