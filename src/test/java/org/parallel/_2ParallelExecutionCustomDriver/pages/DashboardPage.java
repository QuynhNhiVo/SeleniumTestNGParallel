package org.parallel._2ParallelExecutionCustomDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.parallel.keywords.WebUI;
import org.testng.Assert;


public class DashboardPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("(//a[@href='#'][normalize-space()='Logout'])[2]");
    private By menuReport = By.xpath("//span[normalize-space()='Reports']");

    public void clickMenuDashboard(){
        WebUI.clickElement(menuDashboard);
    }

    public CustomersPage clickMenuCustomer(){
        WebUI.clickElement(menuCustomer);
        return new CustomersPage();
    }

    public void clickMenuProject(){
        WebUI.clickElement(menuProject);
    }

    public LoginPage logOut(){
        WebUI.clickElement(dropdownProfile);
        WebUI.clickElement(optionLogout);

        return new LoginPage();
    }

    public void verifyMenuReportDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuCustomer), "Menu Report not Exist.");//check exist
        Assert.assertTrue(WebUI.getWebElement(menuCustomer).isDisplayed(), "Menu Report not Display.");//check display
    }

    public void verifyMenuReportNotDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.checkElementExist(menuCustomer), "Menu Report is Display.");
    }
}
