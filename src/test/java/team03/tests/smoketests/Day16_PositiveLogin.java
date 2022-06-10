package team03.tests.smoketests;


import org.testng.Assert;
import org.testng.annotations.Test;
import team03.page.DefaultPage;
import team03.page.HomePage;
import team03.page.LoginPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;


public class Day16_PositiveLogin {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;

    @Test
    public void adminLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();
//        Verification
        Assert.assertTrue(defaultPage.userID.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void customerLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("customer_password"));
        loginPage.loginButton.click();
//        Verification
        Assert.assertTrue(defaultPage.userID.isDisplayed());
       Driver.closeDriver();
    }
}