package pages;

import base.Base;

import org.openqa.selenium.support.PageFactory;

public class EmployerPage extends Base {

    public EmployerPage() {
        PageFactory.initElements(driver, this);
    }
}
