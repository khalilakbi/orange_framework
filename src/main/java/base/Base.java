package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class Base {

    public static WebDriver driver;
    public static JavascriptExecutor javascriptExecutor;
    public static WebDriverWait wait;
    public static Logger logger;

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        logger = LogManager.getLogger(this.getClass());
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }
    // if test case failed we take screenshot
    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            takeScreenShot(testResult.getName());// call takeScreenShot method
        }
        driver.close();
        driver.quit();
    }

    // selenium api (common api)
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getInnerTextFromElement(WebElement element) {
        return element.getText().trim();// trim() trim white space from beginning and end
    }

    public void hoverOverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public void selectFromDropDownByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    // helper methods
    // take screenshot convert driver to TakesScreenshot interface
    // call the method getScreenshotAs
    public void takeScreenShot(String testName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "screen_shot" + File.separator + testName + ".png";
        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
