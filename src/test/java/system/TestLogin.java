package system;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.ExelData;

import java.io.File;

public class TestLogin extends Base {
    //    WebDriver driver;
//    String validUsername = "Admin";
//    String validPassword = "admin123";
//
//    String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    String path = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "main" +
            File.separator + "resources" +
            File.separator + "testdata.xlsx";

    HomePage homePage;

    String username = ExelData.getDataFromCell(path, "login", 1, 0);
    String password = ExelData.getDataFromCell(path, "login", 1, 1);


    @Test
    public void testValidLogin() throws InterruptedException {
        logger.info("start test case valid login");
        // steps
        homePage = new HomePage();
        logger.info("enter username");
        homePage.enterUserName(username);
        logger.info("enter password");
        homePage.enterPassword(password);
//        Assert.assertTrue(true);
        logger.info("click on login button");
        homePage.clickOnLogin();
        Thread.sleep(1000);
        // assertion (validation)
//        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
//        //Assert.assertTrue(false);
    }

    @Test
    public void testLoginWithoutPassword() throws InterruptedException {
        homePage = new HomePage();
        homePage.enterUserName("Admin");
        homePage.enterPassword("admin123");
        Assert.assertTrue(false);
        //homePage.clickOnLogin();

        //Assert.assertTrue(homePage.isRequiredMSGDisplay());
    }
}
