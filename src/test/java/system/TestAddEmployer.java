package system;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestAddEmployer extends Base {

    String empName = "donald";
    String empLastName = "trump";

    //test case add employer steps
    // open app // login // click on pim // click on add //
    @Test
    public void testAddEmployer() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.doLogin("Admin", "admin123");
        AccountPage accountPage = new AccountPage();
        accountPage.clickOnPIM();
        EmployerPage employerPage = new EmployerPage();
        employerPage.clickOnAdd();
        AddEmployerPage addEmployerPage = new AddEmployerPage();
        addEmployerPage.enterFirstName(empName);
        addEmployerPage.enterLastNAme(empLastName);
        addEmployerPage.enterID("1234");
        addEmployerPage.clickOnSave();
        EmployerDetailPage employerDetailPage = new EmployerDetailPage();
        String empFullName = employerDetailPage.getEmployerFullName();
        String expectedFullName = empName + " " + empLastName;
        Thread.sleep(3000);
        Assert.assertEquals(empFullName, expectedFullName);

    }
}
