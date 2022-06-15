package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _13_Tables extends Base {
    /*
    1. Go to http://the-internet.herokuapp.com/
2. Click on “Sortable Data Tables” link
3. Validate the table 1 headers to be displayed as
below
Last Name
First Name
Email
Due
Web Site
Action
     */
    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        //Locate a List Of WebElements that returns all 6 headers and validate their texts with expected text
        // List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));  we put to POM
        Waiter.pause(3);
        String[] texts = {"Last Name",
                "First Name",
                "Email",
                "Due",
                "Web Site",
                "Action"};
        for (int i = 0; i < texts.length; i++) {
            Assert.assertEquals(heroAppPage.table1Headers.get(i).getText(), texts[i]);
            Assert.assertTrue(heroAppPage.table1Headers.get(i).isDisplayed());

        }
    }

    /*
    1. Go to http://the-internet.herokuapp.com/
 2. Click on “Sortable Data Tables” link
 3. Validate the table 1 row 1 to be displayed as
 below
 Smith
 John
 jsmith@gmail.com
 $50.00
 http://www.jsmith.com
 edit delete
     */
    @Test(priority = 2, description = "Tables | first row")
    public void testFirstRow() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> infoFirstRow = driver.findElements(By.cssSelector("#table1>tbody>tr:nth-child(1)>td"));
        String[] textsExpected = {"Smith", "John",
                "jsmith@gmail.com",
                "$50.00",
                "http://www.jsmith.com",
                "edit delete"};

        for (int i = 0; i < textsExpected.length; i++) {
            Assert.assertEquals(infoFirstRow.get(i).getText(), textsExpected[i]);
            Assert.assertTrue(infoFirstRow.get(i).isDisplayed());
        }
    }
    //table[@id='table1']/tbody/tr/td[2]
    //#table1>tbody td:nth-child(2)
    /*
    1. Go to http://the-internet.herokuapp.com/
2. Click on “Sortable Data Tables” link
3. Validate the table 1 column 2 (First Name) to
be displayed as below
John
Frank
Jason
Tim
     */

    @Test(priority = 3, description = "tables | second column")
    public void testSecondColumn() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> infoSecondColumn = driver.findElements(By.cssSelector("#table1>tbody td:nth-child(2)"));
        String[] textsExpectedSecondRow = {"John", "Frank", "Jason", "Tim"};

        for (int i = 0; i < textsExpectedSecondRow.length; i++) {
            Assert.assertEquals(infoSecondColumn.get(i).getText(), textsExpectedSecondRow[i]);
            Assert.assertTrue(infoSecondColumn.get(i).isDisplayed());
        }
    }
    @Test(priority = 4, description = "tables | all cells")
    public void testAllCells() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));
        System.out.println(allCells.size()); //24
        for (WebElement allCell : allCells) {
            System.out.println(allCell.getText());
            Assert.assertNotEquals(allCell.getText(),"");
        }

        }


}
