package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class _02_LoginPage {

    public _02_LoginPage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "div[id='myAccount']")
    private WebElement textLogin;

    @FindBy(id = "login")
    private WebElement buttonLoginMainPage;

    @FindBy(id = "txtUserName")
    private WebElement inputEmail;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(name = "btnLogin")
    private WebElement buttonLogin;

    @FindBy(xpath = "(//a[@title='Hesabım'])[1]")
    private WebElement textLoginVerification;


    public WebElement getTextLogin() {
        return textLogin;
    }

    public WebElement getButtonLoginMainPage() {
        return buttonLoginMainPage;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getTextLoginVerification() {
        return textLoginVerification;
    }

}
