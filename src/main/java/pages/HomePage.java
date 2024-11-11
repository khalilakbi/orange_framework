package pages;


import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base {
    // var web element

    public static int i;
    @FindBy(name = "username") // locator
    WebElement inputUsername;
    @FindBy(name = "password")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='Required']")
    WebElement requiredMSG;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    // methods actions that we perform in the web app

    public void enterUserName(String username) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        typeText(inputUsername, username);
    }

    public void enterPassword(String password) {
        typeText(inputPassword, password);
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
    }

    public boolean isRequiredMSGDisplay() {
        wait.until(ExpectedConditions.visibilityOf(requiredMSG));
        return requiredMSG.isDisplayed();
    }

    public void doLogin(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLogin();

    }
    // we can have return type for method
//    public AccountPage doLogin(String username,String password){
//        enterUserName(username);
//        enterPassword(password);
//        clickOnLogin();
//        return new AccountPage();
//    }

}
