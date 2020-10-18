package org.example;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SpeedtestHomePageTest extends SeleniumBaseTest{
    SpeedtestHomePage speedtestHomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        speedtestHomePage = new SpeedtestHomePage(webDriver);
        webDriver.get("https://www.speedtest.net");
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void testSpeedtestPage () {
        speedtestHomePage.closePrivacyPolicy()
                         .runTheTest()
                         .readTheTestResults()
                         .assertPing(640)
                         .assertDownload(new BigDecimal("1.1"))
                         .assertUpload(new BigDecimal("1.9"));

    }

}
