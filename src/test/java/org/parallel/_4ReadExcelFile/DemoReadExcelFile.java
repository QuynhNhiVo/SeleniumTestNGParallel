package org.parallel._4ReadExcelFile;

import org.parallel.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFile {
    @Test
    public void testReadExcelFile(){
        ExcelHelper excelHelper = new ExcelHelper();

        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx", "Sheet1");

        System.out.println(excelHelper.getCellData("email", 1));
        System.out.println(excelHelper.getCellData("password", 1));
        System.out.println(excelHelper.getCellData("role", 1));
    }

    @Test
    public void testSetDataToExcel(){
        ExcelHelper excelHelper = new ExcelHelper();

        excelHelper.setExcelFile("src/test/resources/testdata/UserData.xlsx","Sheet1");

        excelHelper.setCellData("Success", "status", 2);
        excelHelper.setCellData("Fail", 3, 1);
    }
}
