package org.parallel.constants;

import org.parallel.helpers.PropertiesHelper;

public class ConfigData {
//    public static String URL = "https://crm.anhtester.com/admin/authentication";
//    public static String email = "admin@example.com";
//    public static String password = "123456";

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static String URL = PropertiesHelper.getValue("url");
    public static String email = PropertiesHelper.getValue("email");
    public static String password = PropertiesHelper.getValue("password");
}
