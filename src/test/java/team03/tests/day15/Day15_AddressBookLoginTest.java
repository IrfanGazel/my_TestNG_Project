package team03.tests.day15;

import org.testng.annotations.Test;
import team03.page.AddressBookLoginPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;

public class Day15_AddressBookLoginTest {

    AddressBookLoginPage addressBookLoginPage = new AddressBookLoginPage();

    @Test
    public void loginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("address_url"));
        addressBookLoginPage.username.sendKeys(ConfigReader.getProperty("address_username"));
        addressBookLoginPage.password.sendKeys(ConfigReader.getProperty("address_pass"));
        addressBookLoginPage.loginButton.click();
    }

}
