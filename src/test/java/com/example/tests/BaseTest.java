package com.example.tests;

import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void baseSetup() {
        driver = DriverFactory.getDriver(); // ⭐ SET DRIVER Ở BASE
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void tearDownSuite() {
        DriverFactory.quitDriver();
    }
}
