package org.parallel._5DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProviderParallel {
    @DataProvider(name = "DataLogin", parallel = true)
    public Object[][] dataLogin(){
        return new Object[][]{
                {"admin@example.com", 123456},
                {"customer@example.com", 456},
                {"employee@example.com", 12}
        };
    }

    @Test(dataProvider = "DataLogin")
    public void testLoginSuccess(String email, int password){
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);
    }
}
