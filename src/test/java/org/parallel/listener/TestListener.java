package org.parallel.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Finish");

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Success");
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Failure");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("on Test Failed But Within Success Percentage");
    }

}
