package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGHomePage {
    public TGHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//img[@alt='Facebook']")  //or one more option from Akin  @FindBy(id = "dataItem-kuiqff9g-comp-kixnxkbc")
    public WebElement facebookIcon;

    @FindBy(css = "#comp-kvjohd5t5>a")
    public static WebElement registerForIntroLink;


}
