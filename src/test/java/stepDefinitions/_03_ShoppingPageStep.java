package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages._02_LoginPage;
import pages.Parent;
import pages._03_ShoppingPage;
import utilities.BaseDriver;

public class _03_ShoppingPageStep extends Parent {

    private final _03_ShoppingPage sp;
    private final _02_LoginPage lp;
    String product = "";

    public _03_ShoppingPageStep(_03_ShoppingPage sp, _02_LoginPage lp) {
        this.sp = sp;
        this.lp = lp;
    }

    @Given("^Write \"([^\"]*)\" to search space and click on search button$")
    public void writeToSearchSpaceAndClickOnSearchButton(String product) {
        waitForStaleElement(sp.getInputSearchSpace());
        sendKeysFunction(sp.getInputSearchSpace(), product);
        clickFunction(sp.getButtonSearch());
        clickFunction(sp.getTelefon());
        clickFunction(sp.getCepTelefonu());
    }

    @And("^Verify that all the results include \"([^\"]*)\"$")
    public void verifyThatAllTheResultsInclude(String product) {
        verifyListContainsText(sp.getProductList(), product);
    }

    @And("^Click on page two and verify that user is on the page two$")
    public void clickOnPageTwoAndVerifyThatUserIsOnThePageTwo() {
        clickFunction(sp.getPage2());
        urlContains("sayfa=2",
                BaseDriver.getDriver());
    }

    @And("^Click on the fifth product and click on the like button$")
    public void clickOnTheFifthProductAndClickOnTheLikeButton() {
        product = sp.getFifthProduct().getText();
        clickFunction(sp.getFifthProduct());
        clickFunction(sp.getButtonLike());
        verifyElementDisplayed(sp.getButtonLikePopUp());
    }

    @And("^Check up that the product is in your liked list and click on liked list$")
    public void checkUpThatTheProductIsInYourLikedListAndClickOnLikedList() {
        scrollToTop();
        moveToElement(lp.getTextLogin());
        clickFunction(sp.getButtonLikedProducts());
        verifyContainsText(sp.getLikedProduct(), product);
        clickFunction(sp.getLikedProduct());
    }

    @And("^Add the product in your cart which you add your liked list$")
    public void addTheProductInYourCartWhichYouAddYourLikedList() {
        clickFunction(sp.getButtonAddToCart());
        verifyElementDisplayed(sp.getTextCartControl());
        clickFunction(sp.getButtonGoToCart());
    }

    @And("^Delete the product that you added to your cart$")
    public void deleteTheProductThatYouAddedToYourCart() {
        clickFunction(sp.getDeleteProductInTheCart());
    }

    @Then("^The product should be deleted in your cart$")
    public void theProductShouldBeDeletedInYourCart() {
        verifyElementDisplayed(sp.getTextEmptyCartControl());
    }
}
