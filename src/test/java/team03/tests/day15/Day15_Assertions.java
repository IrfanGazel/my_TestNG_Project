package team03.tests.day15;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day15_Assertions {

    @Test
    public void hardAssert() {
//        When an assertion fails, then that test case stops execution
//        And rest of the test case will not execute
        System.out.println("Line 11");//runs
        System.out.println("Line 12");//runs
        Assert.assertEquals(3, 4);//runs. FAILS AND STOPS EXECUTION THE REST OF THE CODE IN THIS TEST CASE
        System.out.println("Line 15");//no runs
        Assert.assertEquals("apple", "samsung");//no
        System.out.println("Line 16");//no runs

    }

    @Test
    public void testCase() {
        System.out.println("line 23");//runs
        System.out.println("line 24");//runs
    }

    @Test(dependsOnMethods = "hardAssert")
    public void dependentMethodDemo() {
        System.out.println("line 29");//runs
        System.out.println("line 30");//runs
    }

    @Test
    public void softAssert() {
//        Soft assertion : Verification. Tests continue to execute even after failure
//        1. Create soft assert object
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Line 46");
//        2. use soft assert to logs test as pass or fail
        softAssert.assertEquals(2, 3);
        System.out.println("Line 47");
        softAssert.assertEquals(2, 2);
        System.out.println("Line 51");
        softAssert.assertEquals(2, 4);
        System.out.println("Line 53");

//      3. Use assertAll to verify all soft asserts. this should be the last line in the test case
//        if any case fails, then test case will be marked as failed
        softAssert.assertAll();

    }
}
