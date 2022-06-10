package team03.tests.day15;

import org.testng.annotations.Test;
import team03.utilities.Driver;

public class Day15_FirstDriverClass {
    @Test
    public void firstDriverClass(){
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.closeDriver();

    }
}
