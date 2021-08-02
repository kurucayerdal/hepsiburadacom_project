package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

import java.util.List;

public class _03_ShoppingPage {

    public _03_ShoppingPage() {
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(css = "div[class='desktopOldAutosuggestTheme-container']>input")
    private WebElement inputSearchSpace;

    @FindBy(className = "SearchBoxOld-buttonContainer")
    private WebElement buttonSearch;

    @FindBy(css = "label[for='category-2147483642']")
    private WebElement telefon;

    @FindBy(css = "label[for='category-2147483642_371965']")
    private WebElement cepTelefonu;

    @FindBy(css = "h3[class='product-title title']")
    private List<WebElement> productList;

    @FindBy(css = "a[class='page-2 ']")
    private WebElement page2;

    @FindBy(xpath = "(//h3[@class='product-title title'])[5]")
    private WebElement fifthProduct;

    @FindBy(css = "div[class='Like-1divm']")
    private WebElement buttonLike;

    @FindBy(css = "a[href='https://listelerim.hepsiburada.com/begendiklerim']")
    private WebElement buttonLikePopUp;

    @FindBy(css = "a[title='Beğendiklerim']")
    private WebElement buttonLikedProducts;

    @FindBy(css = "h3[data-test-id='product-card-name']")
    private WebElement likedProduct;

    @FindBy(id = "addToCart")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//span[contains(text(),'Ürün sepetinizde')]")
    private WebElement textCartControl;

    @FindBy(xpath = "//button[contains(text(),'Sepete git')]")
    private WebElement buttonGoToCart;

    @FindBy(css = "a[aria-label='Ürünü Kaldır']")
    private WebElement deleteProductInTheCart;

    @FindBy(xpath = "//h1[contains(text(),'Sepetin şu an boş')]")
    private WebElement textEmptyCartControl;


    public WebElement getInputSearchSpace() {
        return inputSearchSpace;
    }

    public WebElement getButtonSearch() {
        return buttonSearch;
    }

    public WebElement getTelefon() {
        return telefon;
    }

    public WebElement getCepTelefonu() {
        return cepTelefonu;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public WebElement getPage2() {
        return page2;
    }

    public WebElement getFifthProduct() {
        return fifthProduct;
    }

    public WebElement getButtonLike() {
        return buttonLike;
    }

    public WebElement getButtonLikePopUp() {
        return buttonLikePopUp;
    }

    public WebElement getButtonLikedProducts() {
        return buttonLikedProducts;
    }

    public WebElement getLikedProduct() {
        return likedProduct;
    }

    public WebElement getButtonAddToCart() {
        return buttonAddToCart;
    }

    public WebElement getTextCartControl() {
        return textCartControl;
    }

    public WebElement getButtonGoToCart() {
        return buttonGoToCart;
    }

    public WebElement getDeleteProductInTheCart() {
        return deleteProductInTheCart;
    }

    public WebElement getTextEmptyCartControl() {
        return textEmptyCartControl;
    }
}
