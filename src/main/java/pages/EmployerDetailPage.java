package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployerDetailPage extends Base {
    //web element
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    WebElement employerFullName;

    // cons
    public EmployerDetailPage(){
        PageFactory.initElements(driver,this);
    }
    //actions
    public String getEmployerFullName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")));
        return getInnerTextFromElement(employerFullName);
    }
}
