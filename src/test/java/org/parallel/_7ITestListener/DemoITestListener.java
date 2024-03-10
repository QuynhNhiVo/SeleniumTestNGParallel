package org.parallel._7ITestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.parallel.drivers.DriverManager;
import org.parallel.listener.TestListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class DemoITestListener {
    WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        System.out.println("Before Method");
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
    }

    @Test(priority = 1) //Success Test
    public void gotoPage() {
        driver.get("https://anhtester.com");
    }

    @Test(priority = 2) //Failed Test
    public void checkTitle() {
        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
    }

    @Test(priority = 3)  //Skip Test
    public void skipTest() {
        throw new SkipException("Skipping The Test Method ");
    }

    @Test(priority = 4) //Failed Test
    public void checkURL() {
        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getCurrentUrl();
        Assert.assertEquals(originalTitle, expectedTitle, "URL of the website do not match");
    }

    @AfterMethod
    public void closeDriver() {
        System.out.println("After Method");
        driver.quit();
    }

}
