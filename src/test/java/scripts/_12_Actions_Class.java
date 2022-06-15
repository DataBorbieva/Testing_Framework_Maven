package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _12_Actions_Class extends Base {

    @Test(priority = 1, description = "Actions | move to element 1")
    public void moveToElementPractice1() {
        driver.get("https://www.techglobalschool.com/");
        Waiter.pause(2);

        //It must be POM, and we must read it from the page but this is for interview purposes
        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();
        Waiter.pause(2);

        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

    }
/*
•Go to https://www.carvana.com/
•Hover over “FINANCING” menu item (dropdown)
•Validate below items are displayed
WHY FINANCE WITH CARVANA
GET PREQUALIFIED
AUTO LOAN CALCULATOR
Method name = moveToElementPractice2()
Test name = Actions class | move to element 2
 */
@Test(priority = 2, description = "Actions | move to element 2") //This test not stable, because StaleElementException
public void moveToElementPractice2() {
    driver.get("https://www.carvana.com/");
    WebElement financeDropdown = null;

    for (int i = 0; i < 5; i++) {
    if(financeDropdown != null)
        break;
    try {
        driver.navigate().refresh(); //for avoiding StaleElelementExceprion
        financeDropdown = driver.findElement(By.cssSelector("div[data-cv-test='headerFinanceDropdown']"));
    } catch (StaleElementReferenceException e) {
        e.printStackTrace();
        Waiter.pause(2);
    }    }

    Waiter.pause(2);
    //Move to financeDropdown
    Actions actions = new Actions(driver);
    actions.moveToElement(financeDropdown).perform();
    Waiter.pause(2);
    List<WebElement> financeDropdownOptions = driver.findElements(By.cssSelector("a[data-cv-test^='headerFinance']"));

    //Validate texts expected
    String[] optionTexts = {"WHY FINANCE WITH CARVANA", "GET PREQUALIFIED", "AUTO LOAN CALCULATOR"};

    for (int i = 0; i < 3; i++) {
        Assert.assertTrue(financeDropdownOptions.get(i).isDisplayed());
        Assert.assertEquals(financeDropdownOptions.get(i).getText(), optionTexts[i]);
        //System.out.println("======================" + financeDropdownOptions.get(i).getText() + "======================");
    }
}

 /*
    Go to https://www.techglobalschool.com/
    Click on "Register for Intro Session" link
    Validate the url is https://www.techglobalschool.com/apply-now-1
     */

    @Test(priority = 3, description = "Actions | Click")
    public void clickOnElementPractice() {
        driver.get("https://www.techglobalschool.com/");

        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));
//        actions.moveToElement(registerForIntroLink).perform();
//        Waiter.pause(2);
//        actions.click(registerForIntroLink).perform();

        actions.moveToElement(registerForIntroLink).pause(Duration.ofSeconds(2)).click().perform();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/apply-now-1");
    }
    @Test(priority = 4, description = "Actions | Right Click")
    public void rightClickPractice() {
        driver.get("https://www.techglobalschool.com/");
        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));
        actions.contextClick(registerForIntroLink).perform();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/");

    }
/*
1. Go to https://demoqa.com/droppable
2. Click and hold ”Drag me” box and release it
on “Drop here” box
3. Validate “Drop here” text is replaced with
“Dropped!”
Method name = clickHoldAndReleasePractice()
Test name = Actions class | click-hold-release
an element
 */
    @Test(priority = 5, description = "Actions |  Click and Hold - release | drag and drop")
    public void clickHoldAndReleasePractice(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeBox = driver.findElement(By.id("draggable"));
        WebElement dropHereBox = driver.findElement(By.id("droppable"));
        //actions.dragAndDrop(dragMeBox,dropHereBox).perform(); //its faster way, but there is no waits
       actions.clickAndHold(dragMeBox).pause(Duration.ofSeconds(2)).moveToElement(dropHereBox).pause(Duration.ofSeconds(2)).release().perform();
      Assert.assertEquals(dropHereBox.getText(),"Dropped!");


    }
/*
1. Go to https://www.google.com/
2. Enter “Hello” to search input box
3. Validate value attribute is “Hello”
Method name = sendKeysToAnElement ()
Test name = Actions class | send keys to an
element
 */
@Test(priority = 6, description = "Actions | send keys to an element")
    public void sendKeysToAnElement(){
    driver.get("https://www.google.com/");
    actions.sendKeys(googleSearchPage.googleSearchInputBox,"Hello").perform();
    Assert.assertEquals(googleSearchPage.googleSearchInputBox.getAttribute("value"),"Hello");

}
/*
Go to https://www.google.com/
Enter "techglobal" to search input box with uppercases
Validate the value attribute for search input box is "TECHGLOBAL"
Then, copy the text and paste again
Validate the value attribute for search input box is "TECHGLOBALTECHGLOBAL"
 */

    @Test(priority = 7, description = "Actions | key down and key up")
    public void practiceKeyDownAndKeyUp() {
        driver.get("https://www.google.com/");

        //googleSearchPage.searchInputBox.sendKeys("TECHGLOBALTECHGLOBAL");

        actions.keyDown(Keys.SHIFT)
                .sendKeys(googleSearchPage.googleSearchInputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND).sendKeys("v")
                .perform();

        Waiter.pause(2);
        Assert.assertEquals(googleSearchPage.googleSearchInputBox.getText(),"TECHGLOBALTECHGLOBAL");
    }
/*
Go to https://www.etsy.com/
Hover over on "Jewelry & Accessories" menu item
Validate below categories are displayed with their expected texts
Accessories
Bags & Purses
Necklaces
Rings
Earrings
Bracelets
Body Jewelry
All Jewelry
 */


    @Test(priority = 8,description = "Action | Etsy")
    public void navigateToList() {
        driver.get("https://www.etsy.com/");
        actions.moveToElement(etsySearchPage.mainHeaderLinks.get(1)).perform();

        String[] text = {"Accessories", "Bags & Purses", "Necklaces", "Rings", "Earrings", "Bracelets", "Body Jewelry", "All Jewelry"};
        for (int i = 0; i < 8; i++) {
            Waiter.waitUntilTextToBePresentInElement(driver, 10, etsySearchPage.jewelryAndAccessoriesItems.get(i), text[i]);
            Assert.assertEquals(etsySearchPage.jewelryAndAccessoriesItems.get(i).getText(), text[i]);
        }
    }


}