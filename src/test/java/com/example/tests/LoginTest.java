package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginFailDemo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");

        // Đây là assert sai để test fail
        Assert.assertTrue(false, "Force fail to check screenshot");    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//        DriverFactory.quitDriver(); // ✅ CHUẨN
//    }
}
