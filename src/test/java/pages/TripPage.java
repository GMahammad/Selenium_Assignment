import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;



public class TripPage extends PageBase{

    public TripPage(WebDriver driver) {
        super(driver);
    }    

    private By bodyLocator = By.tagName("body");
    private final By usButtonLocator = By.xpath("//a[@id='ng_exp_modal__continue']");
    private final By tripSearchLocator = By.xpath("//button[@class='yellow-btn dropblockbutton']");


    private final By destinationDropLocator = By.xpath("//button[@id='dropdownMenuButtonType']");

    private final By africa = By.xpath("//*[@id='typesdropdown']/a[3]");
    private final By productLocator = By.xpath("//a[@href='https://www.nationalgeographicexpeditions.eu/destinations-eu/']");
    private final By enquireLocator = By.xpath("//a[@href='https://www.nationalgeographicexpeditions.eu/contact-eu/']");
    
     public String getBodyText() {
        return this.waitAndReturnElement(bodyLocator).getText();
    }


    
   
    public void searchTrip(){
        this.waitAndReturnElement(usButtonLocator).click();
        System.out.println("Page title is : " + driver.getTitle());
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        WebElement dropElement = waitAndReturnElement(destinationDropLocator);
        js.executeScript("arguments[0].scrollIntoView();", dropElement);
        dropElement.click();

        WebElement africaElement = waitAndReturnElement(africa);
        js.executeScript("arguments[0].scrollIntoView();", africaElement);
        africaElement.click();

        this.waitAndReturnElement(tripSearchLocator).click();

        WebElement productElement = waitAndReturnElement(productLocator);
        js.executeScript("arguments[0].scrollIntoView();", productElement);
        productElement.click();

        WebElement enquireElement = waitAndReturnElement(enquireLocator);
        js.executeScript("arguments[0].scrollIntoView();", enquireElement);
        enquireElement.click();
    }
}
