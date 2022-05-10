import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;




public class EnquirePage extends PageBase{

    public EnquirePage(WebDriver driver) {
        super(driver);
    }    
    private final By titleLocator = By.xpath("//*[@id='inputTitle']/option[2]");
private final By firstNameLocator = By.name("your-first-name");
private final By lastNameLocator = By.name("your-last-name");
private final By emailLocator = By.name("your-email");
private final By phoneLocator = By.name("your-phone");
private final By countryLocator = By.name("your-country");
private final By enquireTypeLocator = By.xpath("//*[@id='inputEnquiry']/option[8]");
private final By textAreaLocator = By.name("your-message");

private final By input1Locator = By.xpath("//*[@id='contacto']/form/span[17]/label/span");
private final By input2Locator =  By.xpath("//*[@id='contacto']/form/span[19]/label/span");
private final By input3Locator = By.xpath("//*[@id='contacto']/form/span[21]/label/span");

    private By bodyLocator = By.tagName("body");

    
    public String getBodyText() {
        return this.waitAndReturnElement(bodyLocator).getText();
    }

    public void fillEnquireForm(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Page title is : " + driver.getTitle());

        WebElement titleElement = waitAndReturnElement(titleLocator);
        js.executeScript("arguments[0].scrollIntoView();", titleElement);
        titleElement.click();

        WebElement firstNameElement = waitAndReturnElement(firstNameLocator);
        js.executeScript("arguments[0].scrollIntoView();", firstNameElement);
        firstNameElement.sendKeys("Mahammad");

        WebElement lastNameElement = waitAndReturnElement(lastNameLocator);
        js.executeScript("arguments[0].scrollIntoView();", lastNameElement);
        lastNameElement.sendKeys("Gulalov");

        WebElement emailElement = waitAndReturnElement(emailLocator);
        js.executeScript("arguments[0].scrollIntoView();", emailElement);
        emailElement.sendKeys("noyeti4684@chokxus.com");

        WebElement phoneElement = waitAndReturnElement(phoneLocator);
        js.executeScript("arguments[0].scrollIntoView();", phoneElement);
        phoneElement.sendKeys("+1 234 567 890");

        WebElement countryElement = waitAndReturnElement(countryLocator);
        js.executeScript("arguments[0].scrollIntoView();", countryElement);
        countryElement.sendKeys("Hungary");

        WebElement enquireTypeElement = waitAndReturnElement(enquireTypeLocator);
        js.executeScript("arguments[0].scrollIntoView();", enquireTypeElement);
        enquireTypeElement.click();

        WebElement textAreaElement = waitAndReturnElement(textAreaLocator);
        js.executeScript("arguments[0].scrollIntoView();", textAreaElement);
        textAreaElement.sendKeys("I am trying to test your website, do not worry this is for assignment..!");

        WebElement input1Element = waitAndReturnElement(input1Locator);
        js.executeScript("arguments[0].scrollIntoView();", input1Element);
        input1Element.click();

        WebElement input2Element = waitAndReturnElement(input2Locator);
        js.executeScript("arguments[0].scrollIntoView();", input2Element);
        input2Element.click();

        WebElement input3Element = waitAndReturnElement(input3Locator);
        js.executeScript("arguments[0].scrollIntoView();", input3Element);
        input3Element.click();
    }
   
}
