package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ItemSpecificationPage {
    public WebDriver driver;

    @FindBy(xpath = "//a[text() ='В корзину']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Корзина']")
    WebElement cartIcon;

    public ItemSpecificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(){
        addToCartButton.click();
    }

    public void navigateToCart(){
        cartIcon.click();
    }
}
