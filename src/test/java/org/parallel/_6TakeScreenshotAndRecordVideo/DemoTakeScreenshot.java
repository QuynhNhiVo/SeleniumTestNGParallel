package org.parallel._6TakeScreenshotAndRecordVideo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.parallel._2ParallelExecutionCustomDriver.pages.DashboardPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.drivers.DriverManager;
import org.parallel.helpers.CaptureHelper;
import org.parallel.helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoTakeScreenshot extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(testName = "testcase01")
    public void loginSuccess() {
        System.out.println("LOGIN SUCCESS \n");
        CaptureHelper.startRecord("TestLogin");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx", "sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));

        CaptureHelper.takeScreenshot("testLoginSuccess");
        loginPage.verifyLoginSuccess();
//        CaptureHelper.stopRecord();
    }

}
