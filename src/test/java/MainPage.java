import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class MainPage extends PageBase{


    private By bodyLocator = By.tagName("body");
    private By acceptButtonLocator = By.id("onetrust-accept-btn-handler");
    private By loginButton = By.className("UserMenu__Link");

    private final By loginInput = By.id("disneyid-iframe");
    private final By loginFind = By.xpath("//input[@aria-label='Email Address']");
    private final By passwordFind = By.xpath("//input[@aria-label='Password']");


    private final By searchButtonLocator = By.className("NavBar__List--search");
    private final By searchButtonInput = By.className("SearchBar__Input");
    private final By searchResult = By.className("Pagination__Button--next");

    private final By menuButtonLocator = By.xpath("//div[@class='MenuModal NavBar__Menu--item']/button");
    private final By tripButtonLocator = By.xpath("//div[@class='fitt-tracker']//a[@href='https://www.nationalgeographic.com/expeditions/']");
   

    private final By hoverMainLocator = By.xpath("//div[@class='UserMenu__Dropdown__Container']");
    private final By hoverSubLocator = By.xpath("//*[text()='Sign Out']");
  
    public MainPage(WebDriver driver){
        super(driver);
        this.driver.get("https://www.nationalgeographic.com");
    }


    public String getBodyText() {
        return this.waitAndReturnElement(bodyLocator).getText();
    }

    public void acceptPopupMenu() {
        this.waitAndReturnElement(acceptButtonLocator).click();
    }

   

    public void authUser( String email, String password){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement loginButElement = waitAndReturnElement(loginButton);
        js.executeScript("arguments[0].scrollIntoView();", loginButElement);
        loginButElement.click();

        WebElement loginElement = waitAndReturnElement(loginInput);
        this.driver.switchTo().frame(loginElement);

        WebElement login = waitAndReturnElement(loginFind);
        js.executeScript("arguments[0].scrollIntoView();", login);
        login.sendKeys( email +"\n"); 

        WebElement pass = waitAndReturnElement(passwordFind);
        js.executeScript("arguments[0].scrollIntoView();", pass);
        pass.sendKeys( password +"\n"); 
    }
    

    public void testNavHover(){
        JavascriptExecutor js = (JavascriptExecutor) driver;



        Actions actions = new Actions(driver);
        WebElement mainElement =  waitAndReturnElement(hoverMainLocator);
        js.executeScript("arguments[0].scrollIntoView();", mainElement);
        actions.moveToElement(mainElement).perform();

        WebElement subMenu = waitAndReturnElement(hoverSubLocator);
        js.executeScript("arguments[0].scrollIntoView();", subMenu);

        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }
   

    public SearchPage search(String searchQuery) {
        this.waitAndReturnElement(searchButtonLocator).click();
        System.out.println("Page title is : " + driver.getTitle());
        
        this.waitAndReturnElement(searchButtonInput).sendKeys(searchQuery + "\n");
        return new SearchPage(this.driver);
    }
   
    public void menuItem(){
        this.waitAndReturnElement(menuButtonLocator).click();
        this.waitAndReturnElement(tripButtonLocator).click();

    }
 

}