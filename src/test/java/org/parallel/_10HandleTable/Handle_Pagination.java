package org.parallel._10HandleTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.parallel._7ITestListener.pages.CustomersPage;
import org.parallel._7ITestListener.pages.DashboardPage;
import org.parallel._7ITestListener.pages.LoginPage;
import org.parallel.common.BaseTest;
import org.parallel.constants.ConfigData;
import org.parallel.helpers.PropertiesHelper;
import org.parallel.keywords.WebUI;
import org.parallel.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Handle_Pagination extends BaseTest {

    public void checkSearchTableByColumn(int column, String value) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //Xác định số dòng của table sau khi search
        List<WebElement> row = WebUI.getWebElements(By.xpath("//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = WebUI.getWebElement(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));

            WebUI.scrollToElement(elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toLowerCase().contains(value.toLowerCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testCheckDataOnTable(){

        String searchValue = "c";

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.email, ConfigData.password);
        customersPage = dashboardPage.clickMenuCustomer();

//        customersPage.checkPageTotal(7);
//        customersPage.checkSeachTableByColumn(3,"FPT");


        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='clients_length']")));

        select.selectByVisibleText("10");
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item/trang: " + itemTotalOnePage);

        //Set Text on Search input
        WebUI.setText(By.xpath("//input[@class='form-control input-sm']"), searchValue);

        WebUI.sleep(2);

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[normalize-space()='Next']"));
            }
        }
    }

    @Test
    public void testCheckPaginationOnTable() {

        WebUI.openURL("https://datatables.net/");

        //Data search read from Properties
        String searchValue = PropertiesHelper.getValue("searchValue");

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='example_length']")));

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        WebUI.setText(By.xpath("//input[@type='search']"), searchValue);

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='example_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[@id='example_next']"));
            }
        }

    }

}
