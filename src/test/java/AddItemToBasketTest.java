import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToBasketTest extends BaseTest {

    @Test(description = "Adding an Item to the cart")
    @Description("Adding an item to the cart!!!!!!!!!!!!!!!!!!!!!!! allure description")
    public void testAddToBasketTest() throws InterruptedException {


        onlinerHomePage.searchForItem("iPhone 128Gb");
        onlinerHomePage.selectAnItemFromResult(0);
        Thread.sleep(2000);
        itemSpecificationPage.addItemToCart();
        Thread.sleep(2000);
        itemSpecificationPage.navigateToCart();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.getItemTitle().contains("Apple iPhone"));
    }
}
