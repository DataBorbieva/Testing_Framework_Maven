package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExpediaPage {
    public ExpediaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='button']//div") //css = "primary-navigation button" from parent to child , using 'space' between them
    public WebElement moreTravelDropdown;

    @FindBy(xpath = "//a[@data-stid='flight-link']")
    public WebElement flights;

    @FindBy(id = "preferred-class-input-trigger")
    public WebElement flightTypesDropdown;

   // @FindBy(xpath = "(//a[@class='uitk-list-item'])[3]")

    @FindBy(css = "#preferred-class-input>div a")
    public List<WebElement> flightOptions;
}
