package team03.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import team03.utilities.Driver;

public class BluerentalcarsHomePage {

    public BluerentalcarsHomePage() {
        PageFactory.initElements(
                new AjaxElementLocatorFactory(Driver.getDriver(), 10),
                this);
    }

    //@FindBy(xpath="//a[@href='/login']")
    @FindBy(partialLinkText = "Login")
    public WebElement homePageloginBtn;

    @FindBy(xpath = "//select[@name='car']")
    public WebElement carSelectionDropDown;

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUpLocation;

    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement dropOfLocation;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;

    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUpTime;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationBtn;

    @FindBy(xpath = "//*[text()='Please first login']")
    public WebElement pleaseFirstLoginAlert;
}


