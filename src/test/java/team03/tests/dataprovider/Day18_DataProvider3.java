package team03.tests.dataprovider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import team03.page.DefaultPage;
import team03.page.HomePage;
import team03.page.LoginPage;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;
import team03.utilities.ExcelUtil;
import team03.utilities.ReusableMethods;

import java.io.IOException;

public class Day18_DataProvider3 {

    @DataProvider(name = "customer-login-data")
    public Object[][] dataProviderMethod(){
//        This method will be used to get the data from excel sheet
//        path of the excel sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        customer data sheet
        String customerSheet="customer_info";
//        Use ExcelUtil to
        ExcelUtil excelUtil= new ExcelUtil(path,customerSheet);
//       getDataArrayWithoutFirstRow is used to get the data from excel
        Object[][] customerCredentials = excelUtil.getDataArrayWithoutFirstRow();
        return  customerCredentials;
    }

    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();

        try{
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }

        try{
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        }catch (Exception e){

        }
    }


    @Test(dataProvider = "customer-login-data")
    public void customerLogin(String user, String pass) throws IOException {
        login();
        loginPage.username.sendKeys(user);
        loginPage.password.sendKeys(pass.substring(0,5));
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(defaultPage.userID.isDisplayed());
        ReusableMethods.getScreenshot("ManagerLoginTest");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}