package org.parallel.helpers;

import java.io.File;

public class SystemHelper {
    public static String getCurrentDirectory(){
        String path = System.getProperty("user.dir") + File.separator;
        return path;
    }
}
