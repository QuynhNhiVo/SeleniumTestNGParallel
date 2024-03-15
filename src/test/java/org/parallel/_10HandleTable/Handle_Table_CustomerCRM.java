package org.parallel._10HandleTable;

import org.parallel._7ITestListener.pages.CustomersPage;
import org.parallel._7ITestListener.pages.DashboardPage;
import org.parallel._7ITestListener.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.testng.annotations.Test;

public class Handle_Table_CustomerCRM extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testCheckDataOnTable(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.email, ConfigData.password);
        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.searchCustomer("FPT");

//        customersPage.checkPageTotal(7);
        customersPage.checkSeachTableByColumn(3,"FPT");
    }
}
