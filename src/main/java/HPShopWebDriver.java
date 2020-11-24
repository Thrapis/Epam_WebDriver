import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HPShopWebDriver {
    public static WebDriver Driver;
    public static WebElement SearchInputField;
    public static WebElement MonitorInfoLink;
    public static WebElement AddToCartButton;
    public static WebElement ToCartButton;
    public static WebElement CartTotal;
    public static WebElement ProductCount;
    public static WebElement ProductName;

    public static void initialization() {
        Driver = new ChromeDriver();

        Driver.get("https://hp-shop.by/");
        Driver.manage().window().maximize();

        SearchInputField = waitForElementLocatedBy(Driver, By.xpath("//input[@name='search']"));
        SearchInputField.sendKeys("EliteDisplay S430c");
        SearchInputField.submit();

        MonitorInfoLink = waitForElementLocatedBy(Driver, By.xpath("//a[contains(text(), 'EliteDisplay S430c')]"));
        MonitorInfoLink.click();

        AddToCartButton = waitForElementLocatedBy(Driver, By.xpath("//button[@title='Добавить в корзину']"));
        AddToCartButton.click();

        ToCartButton = waitForElementLocatedBy(Driver, By.xpath("//div[@class='header-cart-area']"));
        ToCartButton.click();

        CartTotal = waitForElementLocatedBy(Driver, By.xpath("//td[@id='cart_total']"));
        ProductCount = waitForElementLocatedBy(Driver, By.xpath("//input[@class='shk-count']"));
        ProductName = waitForElementLocatedBy(Driver, By.xpath("//td[@class='th-details']/child::h2/child::a"));
    }

    private static WebElement waitForElementLocatedBy(org.openqa.selenium.WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
