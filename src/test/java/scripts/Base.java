package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;

import javax.swing.*;
import java.nio.channels.AcceptPendingException;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait wait;
    Wait fluentWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage;
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    HeroAppPage heroAppPage;
    FaceBookPage faceBookPage;
    ExpediaPage expediaPage;
    JacquemusBagPage jacquemusBagPage;
    RediffHomePage rediffHomePage;
    AmazonHomePage amazonHomePage;
    TGHomePage tgHomePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        js =(JavascriptExecutor) driver;
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        heroAppPage = new HeroAppPage(driver);
        faceBookPage = new FaceBookPage(driver);
        expediaPage = new ExpediaPage(driver);
        jacquemusBagPage = new JacquemusBagPage(driver);
        rediffHomePage = new RediffHomePage(driver);
        amazonHomePage = new AmazonHomePage(driver);
        tgHomePage = new TGHomePage(driver);


    }

    @AfterMethod
    public void teardown(){
        //TODO If there is a failure take a screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }

}