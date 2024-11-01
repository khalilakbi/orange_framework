package system;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestLogin extends Base {
//    WebDriver driver;
    String validUsername = "Admin";
    String validPassword = "admin123";

    String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    HomePage homePage;



    @Test
    public void testValidLogin() {
        // steps
        homePage = new HomePage();
        homePage.enterUserName(validUsername);
        homePage.enterPassword(validPassword);
        homePage.clickOnLogin();
        // assertion (validation)
        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(false);
    }

    @Test
    public void testLoginWithoutPassword() throws InterruptedException {
        homePage = new HomePage();
        homePage.enterUserName(validUsername);
        homePage.enterPassword("");
        homePage.clickOnLogin();

        Assert.assertTrue(homePage.isRequiredMSGDisplay());
    }
}
