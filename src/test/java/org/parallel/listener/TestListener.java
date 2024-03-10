package org.parallel.listener;

import org.parallel.helpers.CaptureHelper;
import org.parallel.helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Start");
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Finish");

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Start: " + arg0.getName());

        CaptureHelper.startRecord(arg0.getName());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Success: " + arg0.getName());
//        CaptureHelper.takeScreenshot(arg0.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Failure: " + arg0.getName());
        CaptureHelper.takeScreenshot(arg0.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Skipped: " + arg0.getName());
//        CaptureHelper.takeScreenshot(arg0.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Failed But Within Success Percentage" + arg0.getName());
    }

}
