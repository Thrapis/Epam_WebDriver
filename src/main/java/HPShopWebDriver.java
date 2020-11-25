import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HPShopWebDriver {
    public static WebDriver driver;
    public static WebElement searchInputField;
    public static WebElement monitorInfoLink;
    public static WebElement addToCartButton;
    public static WebElement toCartButton;
    public static WebElement cartTotal;
    public static WebElement productCount;
    public static WebElement productName;

    public static void initialization() {
        driver = new ChromeDriver();

        driver.get("https://hp-shop.by/");
        driver.manage().window().maximize();

        searchInputField = waitForElementLocatedBy(driver, By.xpath("//input[@name='search']"));
        searchInputField.sendKeys("EliteDisplay S430c");
        searchInputField.submit();

        monitorInfoLink = waitForElementLocatedBy(driver, By.xpath("//a[contains(text(), 'EliteDisplay S430c')]"));
        monitorInfoLink.click();

        addToCartButton = waitForElementLocatedBy(driver, By.xpath("//button[@title='Добавить в корзину']"));
        addToCartButton.click();

        toCartButton = waitForElementLocatedBy(driver, By.xpath("//div[@class='header-cart-area']"));
        toCartButton.click();

        productCount = waitForElementLocatedBy(driver, By.xpath("//input[@class='shk-count']"));
        productName = waitForElementLocatedBy(driver, By.xpath("//td[@class='th-details']/child::h2/child::a"));
        cartTotal = waitForElementLocatedBy(driver, By.xpath("//td[@id='cart_total']"));
    }

    private static WebElement waitForElementLocatedBy(org.openqa.selenium.WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
