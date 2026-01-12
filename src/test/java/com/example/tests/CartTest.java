package com.example.tests;

import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class CartTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addToCartTest() {
        System.out.println("Add to cart test running");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
