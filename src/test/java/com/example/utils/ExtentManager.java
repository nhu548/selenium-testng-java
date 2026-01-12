package com.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getExtent() {
        if (extent == null) {

            // 🔹 Tạo thư mục nếu chưa có
            String reportDir = "test-output";
            new File(reportDir).mkdirs();

            // 🔹 Tạo tên file theo timestamp
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String reportPath = reportDir + "/ExtentReport_" + time + ".html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Result");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
