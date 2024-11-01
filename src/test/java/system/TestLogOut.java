package system;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

public class TestLogOut extends Base {

    @Test
    public void testLogOut() {
        HomePage homePage = new HomePage();
        homePage.doLogin("Admin", "admin123");
        AccountPage accountPage = new AccountPage();
        //accountPage.clickOnDropDownMenu();
    }
}
