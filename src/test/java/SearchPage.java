import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;



class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }    
}