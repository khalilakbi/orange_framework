package pages;

import base.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployerPage extends Base {
    //var web element
    @FindBy(xpath = "//button[@class= 'oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addEmployerButton;

    public EmployerPage() {
        PageFactory.initElements(driver, this);
    }
    //methods (actions)
    public void clickOnAdd(){
        wait.until(ExpectedConditions.visibilityOf(addEmployerButton));
        clickOnElement(addEmployerButton);
    }

}
