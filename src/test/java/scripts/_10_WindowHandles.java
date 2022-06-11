package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _10_WindowHandles extends Base {

    /*
TEST CASE 1: Validate FaceBook social media icon for TechGlobal School
1. Go to https://www.techglobalschool.com/
2. Click on FaceBook icon in the footer
3. Validate user is routed to https://www.facebook.com/techglobalschool
 */

    @Test(priority = 1, description = " TEST CASE 1: Validate FaceBook social media icon for TechGlobal School")
    public void testTechGlobalSchoolFaceBookIcon(){
        driver.get("https://www.techglobalschool.com/");
        System.out.println(driver.getWindowHandle());//CDwindow-5017A54DEA4C8B9600EDF6B4325AE934 - unique id , that changes every session

        tgHomePage.facebookIcon.click();

        String tgHomeWindowHandle = driver.getWindowHandle();
        //2 tabs
        for(String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(tgHomeWindowHandle)) driver.switchTo().window(windowHandle);
        }


        System.out.println(driver.getTitle()); //TechGlobal School - Home
        System.out.println(driver.getCurrentUrl()); // https://www.facebook.com/techglobalschool

     //   driver.switchTo().window(tgHomeWindowHandle); // to switch back to Tech Global


        //Switching back to TechGlobal School
        System.out.println(driver.getTitle()); //SDET Bootcamp | TechGlobal
        System.out.println(driver.getCurrentUrl()); // https://www.techglobalschool.com/

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/techglobalschool");
    }
/*
1. Go to http://the-internet.herokuapp.com/
2. Click on “Multiple Windows” link
3. Click on “Click Here” link
4. Validate the heading3 as “New Window”
5. Navigate back to previous window
6. Validate the heading3 as “Opening a new
window”
 */

    @Test(priority = 2, description = "TEST CASE 2: Multiple Windows")
    public void testWindowHandle2(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Multiple Windows");

        String mainWindow = driver.getWindowHandle();

        heroAppPage.clickHereLink.click();

        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(heroAppPage.newWindowH3.getText(), "New Window");
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(heroAppPage.windowsH3.getText(), "Opening a new window");
    }

}
