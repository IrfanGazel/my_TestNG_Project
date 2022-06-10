package team03.tests.day15;


import org.testng.annotations.Test;
import team03.utilities.ConfigReader;
import team03.utilities.Driver;

public class Day15_FirstConfigTest {
    @Test
    public void firstConfigTest(){
//        Driver.getDriver().get("https://www.techproeducation.com/");//hard coding
        Driver.getDriver().get(ConfigReader.getProperty("techpro_url"));
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        Driver.closeDriver();
    }

}
