package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
  /*  TC765: Validate Google search
1. Go to "https://www.google.com/"
            2. Search for "Selenium"
            3. Validate the results are more than zero */

    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);}


    @FindBy(className = "gLFyf gsfi")
    public WebElement googleSearchInputBox;

}
