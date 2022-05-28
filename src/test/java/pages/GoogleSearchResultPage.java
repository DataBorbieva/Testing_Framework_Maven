package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

    public GoogleSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);}




    @FindBy(id = "result-stats") //About 1,220,000,000 results (0.47 seconds)
    public WebElement result;

}


