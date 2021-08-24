import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExchangeTest extends BaseTest {

    @Test(description = "Exchange functionality basic test")
    @Description("Just a test of allure '@Description' annotation")
    public void ExchangeRate() throws InterruptedException {

        exchangePage.openExchagnePage();
        Thread.sleep(2000);
        exchangePage.selectCurrencyInEUR();
        exchangePage.selectCurrencyOutBYN();
        exchangePage.setAmount("150");
        Assert.assertEquals(exchangePage.checkCurrencyInValue(), "eur");
        Assert.assertEquals(exchangePage.checkCurrencyOutValue(), "byn");
        Assert.assertEquals(exchangePage.checkAmount(), "150");
    }
}