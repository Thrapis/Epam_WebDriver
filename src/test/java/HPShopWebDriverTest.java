import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HPShopWebDriverTest extends HPShopWebDriver {

    @BeforeTest
    public void setup() {
        initialization();
    }

    @Test
    public void verifyCartTotal() {
        String cartTotalText = CartTotal.getText();
        Double cartTotalValue = Double.parseDouble(cartTotalText.substring(0, cartTotalText.length() - 3).replace(" ", ""));
        Assert.assertTrue(cartTotalValue > 0.0);
    }

    @Test
    public void verifyProductCount() {
        String productCountText = ProductCount.getAttribute("value");
        Integer productCountValue = Integer.parseInt(productCountText);
        Assert.assertEquals((int) productCountValue, 1);
    }

    @Test
    public void verifyProductName() {
        Assert.assertTrue(ProductName.getText().contains("EliteDisplay S430c"));
    }

    @AfterClass
    public void shutdown() {
        Driver.quit();
    }
}
