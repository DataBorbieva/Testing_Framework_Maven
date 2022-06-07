package scripts;

import org.junit.Assert;
import org.testng.annotations.Test;

public class JacquemusBagTest extends Base {

    @Test(priority = 1, description = "TC123")
    public void validateBagImage(){
        driver.get("https://www.jacquemus.com/shop/women/bags");
        Assert.assertTrue(jacquemusBagPage.chiquitoBlueBag.isDisplayed());
    }


}
