package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_Soft_vs_Hard_Assertions {
/*
    @Test(priority = 1,description = "Practicing hard assertions")
    public void method1(){

        //Hard assertions
        //When there is an error at any line, the program will break, and it will not continue with the rest
        Assert.assertTrue(true);
        Assert.assertTrue(false, "==============Failue==============="); //gives us Error
        System.out.println("Hello World"); //this line will not be executed, because we have error
    }
    @Test(priority = 2,description = "Practicing soft assertions")
    public void method2(){
        //Soft assertions
        //
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertTrue(false, "=============Failure==========="); //Assertion error
        System.out.println("Hello World");//prints this line, but does not shows us that we have an error before this line
        softAssert.assertAll();  //Expected :true  <-- we see that in console assertAll() shows us on console
                                 //Actual   :false
    }










*/
}