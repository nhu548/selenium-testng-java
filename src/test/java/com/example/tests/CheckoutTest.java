package com.example.tests;

import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.example.pages.CheckoutPage;
import com.example.utils.DriverFactory;

public class CheckoutTest {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void checkoutTest() {
        checkoutPage.openCheckoutPage();
        checkoutPage.placeOrder();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
