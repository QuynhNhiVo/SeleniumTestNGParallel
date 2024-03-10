package org.parallel._7ITestListener.pages;

import org.openqa.selenium.By;
import org.parallel.constants.ConfigData;
import org.parallel.drivers.DriverManager;
import org.parallel.keywords.WebUI;
import org.testng.Assert;

public class LoginPage {

    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    private void setEmail(String email){
        WebUI.setText(inputEmail,email);
    }

    private void setPassword(String password){
        WebUI.setText(inputPassword,password);
    }

    private void clickButtonLogin(){
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Fail. Còn ở Login Page");
    }

    public void verifyLoginFail(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Fail. Không òn ở Login Page");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message not display");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Error message incorrect");
        //Check menu dashboard not display
    }

    //Các hàm xử lý cho trang này
    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickButtonLogin();

        return new DashboardPage();
    }
}

