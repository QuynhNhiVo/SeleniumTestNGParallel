package org.parallel._7ITestListener.testcases;

import org.parallel._7ITestListener.pages.DashboardPage;
import org.parallel._7ITestListener.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.dataprovider.DataProviderFactory;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(dataProvider = "DataLoginSuccess", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess(String email, String password){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
//        WebUI.captureScreenImage("testLogin");
        dashboardPage.logOut();
    }

    @Test(dataProvider = "DataLoginFail", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithEmailInvalid(String email, String password){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginFail();
//        WebUI.captureScreenImage("testLogin");
    }

//    @Test
//    public void testLoginWithPasswordInvalid(){
//        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM("admin@example.com", "12456");
//        loginPage.verifyLoginFail();
//        WebUI.captureScreenImage("testLogin");
//    }
}
