import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class ASeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;
    public String checkSearch = "THE BEST OF NATIONAL GEOGRAPHIC DELIVERED TO YOUR INBOX";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void multiplicationTest() {


      
        MainPage mainPage = new MainPage(this.driver);
        System.out.println(mainPage.getBodyText());
        Assert.assertTrue(mainPage.getBodyText().contains("Copyright © 1996-2015 National Geographic Society"));
        
        mainPage.acceptPopupMenu();
        
        mainPage.authUser("noyeti4684@chokxus.com","abc_123");
        
        SearchPage searchResultPage = mainPage.search("Animals");
        String bodyText = searchResultPage.getBodyText();
        Assert.assertTrue(mainPage.getBodyText().contains(checkSearch));
        System.out.println("Search Result Checking string:" + checkSearch);

        driver.navigate().back();
        driver.navigate().back();

        mainPage.menuItem();

        TripPage tripPage = new TripPage(this.driver);

        tripPage.searchTrip();
         
        EnquirePage enquirePage = new EnquirePage(this.driver);
        enquirePage.fillEnquireForm();

        driver.navigate().to("https://www.nationalgeographic.com/?loggedout=true&loggedin=true");

        mainPage.testNavHover();

    }
    // @After
    // public void close() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
