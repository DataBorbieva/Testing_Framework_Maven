package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EtsyTest extends Base{



    @Test
    public void testEtsyLogo() {
        driver.get("https://www.etsy.com/");

        WebElement logo = driver.findElement(By.id("logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

@Test
    public void testEtsySearch(){
    driver.get("https://www.etsy.com/");
        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
        //or by css button[data-id='gnav-search-submit-button']
Assert.assertTrue(searchInputBox.isDisplayed());
Assert.assertTrue(searchButton.isDisplayed());

 }
}
