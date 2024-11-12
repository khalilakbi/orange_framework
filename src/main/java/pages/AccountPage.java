package pages;

import base.Base;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountPage extends Base {

    //var

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PIMLink;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropDownMenu;

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    // actions methods (java)

    public void clickOnDropDownMenu() {
        clickOnElement(dropDownMenu);
    }
    public void clickOnPIM(){
        wait.until(ExpectedConditions.visibilityOf(PIMLink));
        clickOnElement(PIMLink);
    }


}
