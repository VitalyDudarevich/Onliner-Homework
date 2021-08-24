package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExchangePage {
    private WebDriver driver;

    @FindBy(xpath="//select[@name='currency-in']")
    public WebElement currencyInValue;

    @FindBy(xpath = "//select[@name='currency-out']")
    public WebElement currencyOutValue;

    @FindBy(xpath = "//select[@name='currency-in']/option[@value='eur']")
    public WebElement currencyInEUR;

    @FindBy(xpath = "//select[@name='currency-out']/option[@value='byn']")
    public WebElement currencyOutBYN;

    @FindBy(xpath = "//input[@name='amount-in']")
    public WebElement amount;

    @FindBy(xpath = "//b[@class='js-cur-result']")
    public WebElement exchangeResult;

    @FindBy(xpath = "//li[@class='bank to-be-removed']/i/p/b")
    public WebElement bestExchangeRate;

    public ExchangePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void openExchagnePage(){
        driver.get("https://kurs.onliner.by/");
    }

    public void selectCurrencyInEUR(){
        currencyInEUR.click();
    }

    public void selectCurrencyOutBYN(){
        currencyOutBYN.click();
    }

    public void setAmount(String setAmount){
        amount.clear();
        amount.sendKeys(setAmount);
    }

    public String getExchangeResult(){
        String str = exchangeResult.getText();
        return str;
    }

    public String checkAmount() {
        String checkAmount = amount.getAttribute("value");
        return checkAmount;
    }

    public String checkCurrencyInValue() {
        String checkCurrencyInValue = currencyInValue.getAttribute("value");
        return checkCurrencyInValue;
    }

    public String checkCurrencyOutValue() {
        String checkCurrencyOutValue = currencyOutValue.getAttribute("value");
        return checkCurrencyOutValue;
    }
}
