package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Mock4_Practice {
    public static void main(String[] args) {
        /**Before Maven and TestNG*/
        //Set up driver
        System.setProperty("webdriver.chrome.driver", "\\Users\\datab\\IdeaProjects\\testng_framework\\chromedriver_win32\\chromedriver.exe");
        //creating driver object
        WebDriver driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        //synchronizing our driver with source code
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //get driver
        driver.get("https://www.jacquemus.com/shop/women/bags");
        //validation
        WebElement bag = driver.findElement(By.xpath("(//img[@alt='Le Chiquito long'])[2]"));
        if(bag.isDisplayed()) System.out.println("Passed");
        else System.out.println("Failed");
        //teardown
        driver.quit();

    }
}
