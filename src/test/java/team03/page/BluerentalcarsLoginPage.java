package team03.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;

public class BluerentalcarsLoginPage {
    public void BluerentalcarsLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement username;
    @FindBy(id = "formBasicPassword")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[text()='invalid credentials']")
    public WebElement invalidCredentialsErrorMessage;
}
