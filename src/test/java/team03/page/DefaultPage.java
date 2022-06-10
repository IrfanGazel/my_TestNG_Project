package team03.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class DefaultPage {
    public DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@id = 'dropdown-basic-button']")
    public WebElement userID;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOut;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;


}
