import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static WebDriver driver;

    public final String AUT_URL = "https://www.onliner.by"; //ApplicationUnderTest_URL

    protected  OnlinerHomePage onlinerHomePage;
    protected  ItemSpecificationPage itemSpecificationPage;
    protected  CartPage cartPage;
    protected  ExchangePage exchangePage;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\AQA\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        logger.info("+++++++++++++++++++++++++ "+ getClass() + " Started at " + System.currentTimeMillis() + " +++++++++++++++++++++++++");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(AUT_URL);

        onlinerHomePage = new OnlinerHomePage(driver);
        itemSpecificationPage = new ItemSpecificationPage(driver);
        cartPage = new CartPage(driver);
        exchangePage = new ExchangePage(driver);
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
        logger.info("+++++++++++++++++++++++++ " + getClass() + " Finished at " + System.currentTimeMillis() + " +++++++++++++++++++++++++");
    }
}


