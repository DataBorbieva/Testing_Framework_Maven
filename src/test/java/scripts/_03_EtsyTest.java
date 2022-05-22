package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EtsyTest extends Base{



    @Test(priority = 1)
    public void testEtsyLogo() {
        driver.get("https://www.etsy.com/");

        WebElement logo = driver.findElement(By.id("logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

@Test (priority = 3)
    public void testEtsySearch(){
    driver.get("https://www.etsy.com/");
        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
        //or by css button[data-id='gnav-search-submit-button']
Assert.assertTrue(searchInputBox.isDisplayed());
Assert.assertTrue(searchButton.isDisplayed());

 }
    @Test (priority = 2,dependsOnMethods = "testEtsySearch" )
    public void testEtsySearchResult() {
        driver.get("https://www.etsy.com/");
        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchInputBox.sendKeys("canvas painting" + Keys.ENTER);
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
      //  searchButton.click();
        WebElement result = driver.findElement(By.xpath("//span[@class='wt-display-inline-flex-sm']//span"));
   //     System.out.println(result.getText());  //1,210,536 results,


        Assert.assertTrue(Integer.parseInt( result.getText().replaceAll("[^0-9]","")) > 0);
        System.out.println(Integer.parseInt( result.getText().replaceAll("[^0-9]",""))); //1210624

    }

}
