package org.parallel.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    //thay thế cho tất cả giá trị Driver bình thường trong project
    public static WebDriver getDriver() {
        return driver.get();
    }

    //Dùng tại BaseTest vị trí Before (cần set giá trị Driver trước khi chạy mỗi @Test)
    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    //Dùng tại BaseTest vị trí After (reset giá trị Driver về null)
    //Xóa víj trí của Driver do trong ThreadLocal sau mỗi testcases
    public static void quit() {
        if(DriverManager.getDriver() != null) {
            DriverManager.driver.get().quit();
            driver.remove();
        }
    }
}
