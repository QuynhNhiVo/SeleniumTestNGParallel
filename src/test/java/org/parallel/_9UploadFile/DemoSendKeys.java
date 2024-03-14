package org.parallel._9UploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.parallel.common.BaseTest;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Test;

public class DemoSendKeys extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys(){
        WebUI.openURL("https://cgi-lib.berkeley.edu/ex/fup.html");

        WebUI.sleep(2);

        By inputFileUpload = By.xpath("//input[@name='upfile']");

//        WebUI.getWebElement(inputFileUpload).sendKeys(System.getProperty("user.dir") + "/src/test/resources/testdata/pexels-pixabay-87651.jpg");
        WebUI.setText(inputFileUpload, System.getProperty("user.dir") + "/src/test/resources/testdata/pexels-pixabay-87651.jpg");

        WebUI.sleep(2);
    }
}
