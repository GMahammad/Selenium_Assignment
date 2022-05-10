# Video

https://www.youtube.com/watch?v=QtiYGKyRUIk

# Selenium testing

We can test UI or webpage with Selenium tests.
Need to define the actions what the user should do to do different actions.

# Gradle

Now we only need to add new dependencies that makes us avaiable to use Selenium tests.
We will use chrome driver but you can find other drivers as well: https://mvnrepository.com/artifact/org.seleniumhq.selenium

```
    testCompile 'org.seleniumhq.selenium:selenium-java:2.52.0'
    testCompile 'org.seleniumhq.selenium:selenium-chrome-driver:2.23.0'
    testCompile 'io.github.bonigarcia:webdrivermanager:4.3.1'
```

First package is the base of the selenium testing.
The second is the Chrome driver, that can be canged to other browser.
The last package is the manager that helps to setup the browser driver.

# Init and close the web driver

We have to initialize the chrome driver first.

```
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
```

We need also a variable to store the driver:
```
    private ChromeDriver driver;
```

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html


Next we maximize the window.

```
    driver.manage().window().maximize();
```

We put this into the setup function that runs before the tests.


```
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
```

In the after phase we quit from the browser if it is initialized well (non-null).
```
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
```

We have to import the used libraries:

```
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
```

# Create a basic test

As an entry point, we can ask the driver, that created in the `setup`, to open a webpage.

```
    @Test
    public void testSelenium() {
        this.driver.get("https://www.inf.elte.hu/en/");
    }
```

# HTML

https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML/Getting_started

# Check a text in the webpage


## Create a wait

In setup phase we create a `WebDriverWait` that handles us how long do we will wait for a page loading or an element appearance.
Not we set this timeout to 10 seconds, so it will throw a timeout exception if 10 second passes without fulfilling a condition.

In the setup:
```
wait = new WebDriverWait(driver, 10);
```

In the class we add a variable:
```
private WebDriverWait wait;
```

What condition?

```
this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
```

To use this we have to import ExpectedConditions:

```
import org.openqa.selenium.support.ui.*;
```

With this line, we ask our `WebDriverWait` to wait for appearing of an element.
This element will be denoted by tag name "body".
That means in normal words: please wait until the body of the website will appear or throw an exception if it is longer than 10 seconds.

## Get something

Now we know there is a body, so we can get it... and get the text of it.
We ask the driver to please return us the body and from that point the elemnet can give us the text of the whole body.

```
    WebElement resultElement = this.driver.findElement(By.tagName("body"));
    System.out.println(resultElement.getText());
```

By default the gradle won't show standard output on every version, so we may have to enable now.
Add into gradle the following:
```
test{
    testLogging {
        outputs.upToDateWhen {false}
        showStandardStreams = true
    }
}
```

We can use multiple `By` functions, like `className`, `cssSelector`, `id​`, `name`, `linkText`, `partialLinkText​`, `tagName`.

For more info: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/By.html

# Write nicer code

If we create a final variable in the class that defines the `By`, we do not have to repeat ourselves.
```
    private final By bodyLocator = By.tagName("body");
```

After this we can use shorter version:
```
    this.wait.until(ExpectedConditions.visibilityOfElementLocated(bodyLocator));
    WebElement resultElement = this.driver.findElement(bodyLocator);
```

# Do some interaction

```
    this.driver.get("https://www.inf.elte.hu/en/");

    this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer-block")));
    WebElement resultElement = this.driver.findElement(By.className("footer-block"));
    System.out.println(resultElement.getText());
    Assert.assertTrue(resultElement.getText().contains("2021 ELTE Faculty of Informatics"));

    this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-bar-toggler")));
    WebElement searchBarToggler = this.driver.findElement(By.className("search-bar-toggler"));
    searchBarToggler.click();

    this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
    WebElement searchBar = this.driver.findElement(By.name("search"));
    searchBar.sendKeys("Students\n");

    this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    WebElement bodyAgain = this.driver.findElement(By.tagName("body"));
    System.out.println(bodyAgain.getText());
    Assert.assertTrue(bodyAgain.getText().contains("FOUND"));
    Assert.assertTrue(bodyAgain.getText().contains("Current Students"));
```

# Do it nicer

We can introduce a new function that waits for the visibility and after returns the element.

```
    private WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
```

With this function we can write shorter our test case.

```
    this.driver.get("https://www.inf.elte.hu/en/");
    Assert.assertTrue(this.waitAndReturnElement(By.className("footer-block")).getText().contains("2021 ELTE Faculty of Informatics"));

    this.waitAndReturnElement(By.className("search-bar-toggler")).click();

    this.waitAndReturnElement(By.name("search")).sendKeys("Students\n");

    WebElement bodyElemnet = this.waitAndReturnElement(By.tagName("body"));
    System.out.println("-------------------------------------");
    System.out.println(bodyElemnet.getText());
    Assert.assertTrue(bodyElemnet.getText().contains("FOUND"));
    Assert.assertTrue(bodyElemnet.getText().contains("Current Students"));
```



# Task

- Attendance
- Open the http://selenium.thinkcode.se page with selenium
- Open the request password example by clicking onto the "Request password - fill out and submit a form" link. This click has to be done by the Selenium, so do not get directly the http://selenium.thinkcode.se/requestPassword url.
- Request a new password on the example page. Check the printed username is correct or not.

