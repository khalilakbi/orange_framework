package pages;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import java.util.prefs.BackingStoreException;

public class BuzzPage extends Base {
    // var

    //cons
    public BuzzPage(){
        PageFactory.initElements(driver,this);
    }
    //methods

}
