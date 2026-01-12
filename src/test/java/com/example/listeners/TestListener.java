package com.example.listeners;

import com.aventstack.extentreports.*;
import com.example.utils.ExtentManager;
import com.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterSuite;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtent();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((com.example.tests.BaseTest) currentClass).getDriver(); // lấy driver từ test class

        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

        // Add vào report
        test.get().fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        // ⭐ CHÍNH DÒNG NÀY: đảm bảo report flush ra file
        extent.flush();
    }
}
