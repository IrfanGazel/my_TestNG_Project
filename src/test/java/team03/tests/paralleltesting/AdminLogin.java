package team03.tests.paralleltesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import team03.utilities.Driver;
import team03.utilities.ReusableMethods;

import java.time.Duration;

public class AdminLogin {
    @Test
    public void customerLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bluerentalcars.com/login");
        driver.findElement(By.id("formBasicEmail")).sendKeys("admin@bluerentalcars.com");
        ReusableMethods.waitFor(2);
        driver.findElement(By.id("formBasicPassword")).sendKeys("12345");
        ReusableMethods.waitFor(2);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.close();
    }
}



