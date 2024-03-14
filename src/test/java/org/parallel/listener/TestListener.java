package org.parallel.listener;

import com.aventstack.extentreports.Status;
import org.parallel.helpers.CaptureHelper;
import org.parallel.helpers.PropertiesHelper;
import org.parallel.reports.AllureReportManager;
import org.parallel.reports.ExtentReportManager;
import org.parallel.reports.ExtentTestManager;
import org.parallel.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }


    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("on Start");
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("on Finish");

        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("********on Test Start: " + result.getName() + "********");

        if(PropertiesHelper.getValue("VIDEO_RECORD").equals("true")){
            CaptureHelper.startRecord(result.getName());
            ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("==> " + result.getName() + " Test Success: ");
//        CaptureHelper.takeScreenshot(result.getName());
        if(PropertiesHelper.getValue("VIDEO_RECORD").equals("true")) {
            CaptureHelper.stopRecord();
        }
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("==> " + result.getName() + " Test Failure: ");
        if(PropertiesHelper.getValue("SCREENSHOT_FAIL").equals("true")){
            CaptureHelper.takeScreenshot(result.getName());
        }

        if(PropertiesHelper.getValue("VIDEO_RECORD").equals("true")) {
            CaptureHelper.stopRecord();
        }
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        //Allure Report
        AllureReportManager.saveTextLog(result.getName() + " is failed.");
        AllureReportManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.warn("on Test Skipped: " + result.getName());
//        CaptureHelper.takeScreenshot(result.getName());

        if(PropertiesHelper.getValue("VIDEO_RECORD").equals("true")) {
            CaptureHelper.stopRecord();
        }
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("on Test Failed But Within Success Percentage" + result.getName());
    }

}
