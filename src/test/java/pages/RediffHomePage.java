package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RediffHomePage {

        public RediffHomePage(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[@class='div_container']/div")
        public WebElement cellOne;

    @FindBy(xpath = "(//div[@class='div_container']//div)[2]")
    public WebElement cellTwo;

    @FindBy(id = "moneyiframe")
    public WebElement innerIFrame;
    }
/*

    @FindBy(css = "div[class^='cell']")
    public List<WebElement> moneyCells;

    @FindBy(id = "moneyiframe")
    public WebElement moneyIFrame;
}
 */