package org.parallel.listener;

import org.parallel.helpers.CaptureHelper;
import org.parallel.helpers.PropertiesHelper;
import org.parallel.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

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

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("********on Test Start: " + result.getName() + "********");

        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("==> " + result.getName() + " Test Success: ");
//        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("==> " + result.getName() + " Test Failure: ");
        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.warn("on Test Skipped: " + result.getName());
//        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("on Test Failed But Within Success Percentage" + result.getName());
    }

}
