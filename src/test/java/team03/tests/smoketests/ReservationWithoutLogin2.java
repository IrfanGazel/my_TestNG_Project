package team03.tests.smoketests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03.page.ReservationPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

public class ReservationWithoutLogin2 {
    ReservationPage reservationPage;

    @Test
    public void reservationWithoutLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        reservationPage = new ReservationPage();

        Select select = new Select(reservationPage.selectCar);
        ReusableMethods.selectRandomTextFromDropdown(select);//select random car

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("location")).perform();//location from .properties file
        reservationPage.selectLocation.click();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("location")).perform();
        reservationPage.selectLocation.click();

        reservationPage.pickUpDate.sendKeys(ConfigReader.getProperty("pickup_date"));//from .properties file 0020220909
        reservationPage.pickUpTime.sendKeys(ConfigReader.getProperty("pickup_time"));//from .properties file 1010AM
        reservationPage.dropOffDate.sendKeys(ConfigReader.getProperty("dropoff_date"));//from .properties file 0020220909
        reservationPage.dropOffTime.sendKeys(ConfigReader.getProperty("dropoff_time"));//from .properties file 1130PM
        reservationPage.submitButton.click();



        ReusableMethods.waitForVisibility(reservationPage.pleaseLoginFirstErrorMessage, 5);
        Assert.assertTrue(reservationPage.pleaseLoginFirstErrorMessage.isDisplayed());


    }
}