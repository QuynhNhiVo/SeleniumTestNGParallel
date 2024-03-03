package org.parallel._2ParallelExecutionCustomDriver.testcases;

import org.parallel._2ParallelExecutionCustomDriver.pages.CustomersPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.DashboardPage;
import org.parallel._2ParallelExecutionCustomDriver.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.parallel.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenCustomerPage(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.email,ConfigData.password);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();
    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }
//
//    @Test
//    public void testProjectRole(){
//        loginPage = new LoginPage(driver);
//        dashboardPage = loginPage.loginCRM("project@example.com","123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage.verifyMenuReportNotDisplay();
//    }
}
