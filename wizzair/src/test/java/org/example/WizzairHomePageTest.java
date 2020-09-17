package org.example;

import org.junit.Before;
import org.junit.Test;

public class WizzairHomePageTest extends SeleniumBaseTest {
private WizzairHomePage wizzairHomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        wizzairHomePage = new WizzairHomePage(webDriver);
        webDriver.get("https://wizzair.com/#/");
    }

    @Test
    public void clickPopUpButton () {
        wizzairHomePage.clickPopUpButton();
    }
}
