package org.parallel._9UploadFile;

import org.openqa.selenium.By;
import org.parallel.common.BaseTest;
import org.parallel.helpers.SystemHelper;
import org.parallel.keywords.WebUI;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DemoRobotClass extends BaseTest {

    @Test
    public void testUploadFile2(){
        WebUI.openURL("https://files.fm/");
        WebUI.sleep(2);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = SystemHelper.getCurrentDirectory() + "src\\test\\resources\\testdata\\pexels-pixabay-87651.jpg";

        //Click để mở form upload
        WebUI.clickElement(divFileUpload);
        WebUI.sleep(2);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        WebUI.sleep(1);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        WebUI.sleep(1);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebUI.sleep(1);

        By fileName = By.xpath("//span[@class='filename']");
        WebUI.checkElementDisplay(fileName);

    }
}
