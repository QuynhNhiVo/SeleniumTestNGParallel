package org.parallel._2ParallelExecutionCustomDriver.testcases;

import org.parallel._2ParallelExecutionCustomDriver.pages.DashboardPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.parallel.dataprovider.DataProviderFactory;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(dataProvider = "DataLoginSuccess", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess(String email, String password){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLogin");
        dashboardPage.logOut();
    }
    @Test(dataProvider = "DataLoginFail", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithEmailInvalid(String email, String password){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLogin");
    }

    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "12456");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLogin");
    }
}
