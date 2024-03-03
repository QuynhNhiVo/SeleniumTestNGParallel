package org.parallel._3ReadPropertiesFile;

import org.parallel.constants.ConfigData;
import org.parallel.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFiles {
    @Test
    public void testReadPropertiesFiles(){

        PropertiesHelper.loadAllFiles();

        System.out.println(PropertiesHelper.getValue("url"));
//        System.out.println(ConfigData.URL);
        System.out.println(PropertiesHelper.getValue("email"));
        System.out.println(PropertiesHelper.getValue("password"));
        System.out.println(PropertiesHelper.getValue("te"));

        //Gộp nhiều file
        System.out.println(PropertiesHelper.getValue("key1"));
        System.out.println(PropertiesHelper.getValue("key2"));
    }
}
