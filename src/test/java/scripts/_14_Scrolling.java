package scripts;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.TGHomePage;
import utilities.Waiter;

public class _14_Scrolling extends Base{

    @Test
    public void testScrolling(){
        driver.get("https://www.techglobalschool.com/");
        Waiter.pause(3);
      //  actions.moveToElement(TGHomePage.registerForIntroLink).perform();
     //   actions.sendKeys(Keys.PAGE_DOWN).perform();
    //    Waiter.pause(3);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  JavascriptExecutor js =(JavascriptExecutor) driver;
    //    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",tgHomePage.registerForIntroLink);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})",tgHomePage.facebookIcon); //fbIcon was at the end of page. but still foun


    }
}
