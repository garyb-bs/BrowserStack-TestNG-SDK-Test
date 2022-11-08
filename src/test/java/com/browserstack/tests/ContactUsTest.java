package com.browserstack.tests;

import com.browserstack.pages.ContactUsPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

public class ContactUsTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);

        driver.manage().window().maximize();

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void fillContactForm() {
        driver.get(contactUsURL);

        homePage.goToContactUsPage();

        contactUsPage.fillContactForm(name, emailAddress, subjectText, messageText);

        Assert.assertTrue(contactUsPage.getSuccessMessageElement().isDisplayed());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
