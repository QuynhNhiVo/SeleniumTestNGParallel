package org.parallel._2ParallelExecutionCustomDriver.testcases;

import org.parallel._2ParallelExecutionCustomDriver.pages.DashboardPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.email, ConfigData.password);
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLogin");
        dashboardPage.logOut();
    }
    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@email.com", "123456");
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
