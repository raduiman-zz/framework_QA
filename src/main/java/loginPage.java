import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class loginPage {

    //    public WebDriver chromeDriver = new ChromeDriver();
    public WebDriver firefoxDriver = new FirefoxDriver();
    public String baseUrl = "http://shop.demoqa.com";
    public String username = "qaworkshopsv@mailinator.com";
    public String password = "QAWorkshopSV1!";

    @BeforeTest
    public void openPage() {
        /**
         * Use Selenium to open the following URL http://shop.demoqa.com/
         * Click the My Account link in the top right corner
         * On the Login/Sign In page
         * Insert  credentials into email/password fields
         * Click Log In
         */
        //        chromeDriver.get(baseUrl);
        firefoxDriver.get(baseUrl);
        firefoxDriver.findElement(By.cssSelector(".woocommerce-store-notice__dismiss-link")).click();
        firefoxDriver.findElement(By.cssSelector(".pull-right > li:nth-child(2) > a:nth-child(1)")).click();
        firefoxDriver.findElement(By.id("username")).sendKeys(username);
        firefoxDriver.findElement(By.id("password")).sendKeys(password);
        firefoxDriver.findElement(By.cssSelector("button.woocommerce-button:nth-child(4)")).click();
    }

    @Test
    public void loginPage(){
        /**
         * Assert the page that loaded after login is the expected one
         */
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(URL, "http://shop.demoqa.com/my-account/");
    }

    @AfterTest
    public void quitPage(){
        /**
         * Quit browser
         */
        //        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
