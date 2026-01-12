package com.example.pages;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCheckoutPage() {
        driver.get("https://example.com/checkout");
    }

    public void placeOrder() {
        System.out.println("Placing order...");
    }
}
