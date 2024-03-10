package org.parallel._7ITestListener.testcases;

import org.parallel._7ITestListener.pages.CustomersPage;
import org.parallel._7ITestListener.pages.DashboardPage;
import org.parallel._7ITestListener.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.email, ConfigData.password);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();

        customersPage.clickButtonAddNew();

        String COMPANY_NAME = "1 F Test";
        customersPage.inputFromData(COMPANY_NAME);
        dashboardPage.clickMenuCustomer();
        customersPage.searchAndVerifyCustomer(COMPANY_NAME);
        customersPage.verifyCustomerDetail(COMPANY_NAME);
    }
}
