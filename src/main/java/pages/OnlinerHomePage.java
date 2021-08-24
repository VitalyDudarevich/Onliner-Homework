package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnlinerHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@data-project='onliner_main']")
    WebElement search;

    @FindBy(xpath = "//iframe[@class='modal-iframe']")
    WebElement SearchResultiframe;

    public OnlinerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OnlinerHomePage searchForItem(String item) {
        search.sendKeys(item);
        return new OnlinerHomePage(driver);
    }

    public void selectAnItemFromResult(Integer itemNumber) {
        driver.switchTo().frame(SearchResultiframe);
        List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='search__content-wrapper']/ul/li[@class='search__result']"));
        listOfItems.get(itemNumber).click();
    }

    public void openOnlinerHomePage() {
        driver.get("https://onliner.by");
    }

}
