package org.parallel.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.parallel.drivers.DriverManager;
import org.parallel.helpers.CaptureHelper;
import org.parallel.helpers.PropertiesHelper;
import org.parallel.listener.TestListener;
import org.parallel.utils.LogUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite
    private void beforeSuite(){
        //Chỉ cần load 1 lần là đã lưu giá trị vào bộ nhớ áp dụng cho toàn phiên chạy
        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browserName) {
        LogUtils.info("create Driver");
        WebDriver driver = setupBrowser(browserName);//Khởi tạo loại Driver
//        new WebUI(driver);
        DriverManager.setDriver(driver);//Mang giá trị Driver vào ThreadLocal
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public WebDriver setupBrowser(String browserName){
        WebDriver driver; //Khai báo Driver cục bộ
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                LogUtils.info("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private WebDriver initChromeDriver() {
        WebDriver driver; //Khai báo Driver cục bộ
        LogUtils.info("Launching Chrome browser...");
        ChromeOptions options = new ChromeOptions();
        if(PropertiesHelper.getValue("HEADLESS").equals("true")){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        WebDriver driver; //Khai báo Driver cục bộ (tạm thời)
        LogUtils.info("Launching Edge browser...");
        EdgeOptions options = new EdgeOptions();
        if(PropertiesHelper.getValue("HEADLESS").equals("true")){
            options.addArguments("--headless");
        }
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        DriverManager.quit();
    }

}
