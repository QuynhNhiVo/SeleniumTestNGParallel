package org.parallel.dataprovider;

import org.parallel.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "DataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess(){
//        return new Object[][]{
//                {"admin@example.com", "123456"},
////                {"customer@example.com", "123456"}
//        };
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/datalogin.xlsx", "sheet2");

        return data;
    }

    @DataProvider(name = "DataLoginFail", parallel = false)
    public Object[][] dataLoginFail(){
        return new Object[][]{
                {"admin@email.com", "123456"},
                {"customer@example.com", "12456"}
        };
    }

    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/datalogin.xlsx", "Sheet3", 1, 1);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}
