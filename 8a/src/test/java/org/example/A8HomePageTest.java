package org.example;

import org.junit.Before;
import org.junit.Test;

public class A8HomePageTest extends SeleniumBaseTest{
    private A8HomePage a8HomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        a8HomePage = new A8HomePage(webDriver);
        webDriver.get("https://8a.pl");
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void A8Test () {
        a8HomePage.confirmCookie()
                    .clickMensMenu()
                    .clickMeansCloth()
                    .clickMeansJacketsCategory();

    }


}
