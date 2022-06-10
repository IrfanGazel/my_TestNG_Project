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

public class ReservationWithoutLogin {
    ReservationPage reservationPage;

    @Test
    public void reservationWithoutLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        reservationPage = new ReservationPage();

        Select select = new Select(reservationPage.selectCar);
        ReusableMethods.selectRandomTextFromDropdown(select);

        Actions actions = new Actions(Driver.getDriver());
        //selecting pickup location
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("location")).perform();
        reservationPage.selectLocation.click();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("location")).perform();
        reservationPage.selectLocation.click();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pickup_date")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("pickup_time")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("dropoff_date")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("dropoff_time"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitForVisibility(reservationPage.pleaseLoginFirstErrorMessage, 5);
        Assert.assertTrue(reservationPage.pleaseLoginFirstErrorMessage.isDisplayed());

    }
}