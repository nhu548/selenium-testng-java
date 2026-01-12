package com.example;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {

    @Test
    public void openGoogle() {
        // Xóa cache driver cũ, tự tải driver Chrome tương thích
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
