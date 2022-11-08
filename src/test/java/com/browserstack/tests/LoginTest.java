package com.browserstack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfully() {
        driver.get(url);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();

        Assert.assertTrue(driver.getCurrentUrl().contains(loginPage.loggedInUrlSnippet));
    }

    @Test
    public void wrongUsernameEntered() {
        driver.get(url);

        loginPage.enterUsername(wrongUsername);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();

        Assert.assertTrue(loginPage.getErrorMessageElement().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageElement().getText(), loginPage.invalidUserMessage);
    }

    @Test
    public void wrongPasswordEntered() {
        driver.get(url);

        loginPage.enterUsername(username);
        loginPage.enterPassword(wrongPassword);
        loginPage.clickSubmitButton();

        WebElement invalidUsernameElement = driver.findElement(By.cssSelector("#error"));
        Assert.assertTrue(invalidUsernameElement.isDisplayed());
        Assert.assertEquals(invalidUsernameElement.getText(), loginPage.invalidPasswordMessage);
    }
}
