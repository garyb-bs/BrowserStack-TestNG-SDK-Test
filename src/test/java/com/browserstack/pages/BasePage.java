package com.browserstack.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {
    public WebDriver driver;
    public Wait<WebDriver> fluentWait;
    public JavascriptExecutor js;
    public Actions actions;
}
