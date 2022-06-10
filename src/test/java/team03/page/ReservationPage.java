package team03.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team03.utilities.Driver;



public class ReservationPage {


    public ReservationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='car']")
    public WebElement selectCar;

    @FindBy(xpath = "//*[text()='Virginia']")//choosing a city after selecting a state
    public WebElement selectLocation;

    @FindBy(xpath = "//*[text()='Please first login']")
    public WebElement pleaseLoginFirstErrorMessage;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;

    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUpTime;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton;


}
