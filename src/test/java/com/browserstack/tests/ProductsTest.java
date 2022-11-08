package com.browserstack.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductsToCartFromDetailsPage() {
        driver.get(url);

        homePage.goToProductsPage();

        productsPage.viewProduct(1);
        productsPage.addToCart();
        productsPage.viewCart();

        Assert.assertEquals(fluentWait.until(webDriver -> driver.findElements(By.xpath("//tbody/tr"))).size(), 1);

        homePage.goToProductsPage();

        productsPage.viewProduct(2);
        productsPage.addToCart();
        productsPage.viewCart();

        Assert.assertEquals(fluentWait.until(webDriver -> driver.findElements(By.xpath("//tbody/tr"))).size(), 2);
    }

    @Test
    public void addProductsToCartFromProductsPage() {
        driver.get(url);

        homePage.goToProductsPage();

        productsPage.hoverAndAddProductToCart(1);
        productsPage.viewCart();

        homePage.goToProductsPage();

        productsPage.hoverAndAddProductToCart(2);
        productsPage.viewCart();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
