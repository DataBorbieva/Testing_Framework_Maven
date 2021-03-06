package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

   /*
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Validate "Female", "Male" and "Custom" radio buttons are displayed, enabled and not selected
    Select "Female" and validate it is selected
    Select "Male" radio button and validate "Male" is selected and "Female" is deselected
     */

public class _06_RadioButtonTest extends Base{
@Test(priority = 1, description = "TC234: Validate Facebook gender radio buttons")
public void testFacebookGenderRadioButtons(){
        driver.get("https://www.facebook.com/");
        Waiter.pause(2);

        faceBookPage.createNewAccountLink.click();
        Waiter.pause(2);

        for(WebElement element : faceBookPage.genderRadioButtons){
       /* Assert.assertTrue(element.isDisplayed(), "Element IS NOT displayed");   HARD ASSERTION
        Assert.assertTrue(element.isEnabled(), "Element IS NOT enabled");
        Assert.assertFalse(element.isSelected(), "Element IS selected"); */
                softAssert.assertTrue(element.isDisplayed(), "Element IS NOT displayed");
                softAssert.assertTrue(element.isEnabled(), "Element IS NOT enabled");   //SOFT ASSERTION
                softAssert.assertFalse(element.isSelected(), "Element IS selected"); // We did it soft because it is not for main critical functionalities
        }

        faceBookPage.genderRadioButtons.get(0).click();
        Waiter.pause(2);
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(0).isSelected());

        faceBookPage.genderRadioButtons.get(1).click();
        Waiter.pause(2);
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(1).isSelected());
        Assert.assertFalse(faceBookPage.genderRadioButtons.get(0).isSelected());

        }
        }