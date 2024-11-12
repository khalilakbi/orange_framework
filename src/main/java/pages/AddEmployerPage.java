package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployerPage extends Base {
    //web element
    @FindBy(name = "firstName")
    WebElement inputFirstName;

    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class ='oxd-input oxd-input--active']")
    WebElement inputID;

    @FindBy(xpath = "//button[@class= 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement saveButton;

    //constructor
    public AddEmployerPage(){
        PageFactory.initElements(driver,this);
    }
    // actions
    public void enterFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOf(inputFirstName));
        typeText(inputFirstName,firstName);
    }
    public void enterLastNAme(String lastName){
        typeText(inputLastName,lastName);
    }
    public void enterID(String id){
       typeText(inputID,id);
    }
    public void clickOnSave(){
        clickOnElement(saveButton);
    }

}
