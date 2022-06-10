package team03.tests.smoketests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team03.page.HomePage;
import team03.page.LoginPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

public class Day16_NegativeLogin {
    HomePage homePage; //login link
    LoginPage loginPage; // username, password, submit button
    Faker faker;

    @Test
    public void negativeLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginButton.click();
        //verification
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsErrorMessage,5);
        Assert.assertTrue(loginPage.invalidCredentialsErrorMessage.isDisplayed());
        Driver.closeDriver();

    }

}
