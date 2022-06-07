package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JacquemusBagPage {
    public JacquemusBagPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

 @FindBy(xpath = "(//img[@alt='Le Chiquito moyen'])[1]")
    public WebElement chiquitoBlueBag;





}
