package org.parallel._4ReadExcelFile;

import org.parallel._2ParallelExecutionCustomDriver.pages.DashboardPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.parallel.helpers.ExcelHelper;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx", "sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));

        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLogin");
        dashboardPage.logOut();
    }
    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx", "sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2));

        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLogin");
    }

    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx", "sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 3),
                excelHelper.getCellData("password", 3));

        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLogin");
    }
}
