package org.parallel._8Log4j2;

import org.parallel.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoWriteLog {
    @Test
    public void testWriteLog(){
        LogUtils.info("Log 1");
    }

    @Test
    public void testWriteLog2(){
        LogUtils.info("Log 2");
    }

    @Test
    public void testWriteLog3(){
        LogUtils.info("Log 3");
    }

    @Test
    public void testWriteLog4(){
        LogUtils.info("Log 4");
    }
}
