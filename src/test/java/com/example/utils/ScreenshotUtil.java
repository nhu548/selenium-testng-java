package com.example.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("❌ DRIVER NULL – KHÔNG CHỤP ĐƯỢC");
            return null;
        }
        try {
            String time =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String path =
                    "test-output/screenshots/" + testName + "_" + time + ".png";

            File src =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File(path));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
