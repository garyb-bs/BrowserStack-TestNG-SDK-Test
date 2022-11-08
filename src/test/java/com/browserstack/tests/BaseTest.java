package com.browserstack.tests;

import com.browserstack.pages.ContactUsPage;
import com.browserstack.pages.HomePage;
import com.browserstack.pages.LoginPage;
import com.browserstack.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

public class BaseTest {
    public WebDriver driver;
    public Wait<WebDriver> fluentWait;

    // Page Object Instances
    public HomePage homePage;
    public ContactUsPage contactUsPage;
    public LoginPage loginPage;
    public ProductsPage productsPage;

    // Contact Us Test Strings
    public String contactUsURL = "https://automationexercise.com";
    public String name = "Firstname Lastname";
    public String emailAddress = "test@email.com";
    public String subjectText = "The Subject";
    public String messageText = "This is the content of the message text";

    // Login Test Strings
    public String url = "https://practicetestautomation.com/practice-test-login/";
    public String username = "student";
    public String password = "Password123";
    public String wrongUsername = "wrong-student";
    public String wrongPassword = "Password456";


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);

        driver.manage().window().maximize();

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
