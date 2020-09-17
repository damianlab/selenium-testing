package org.example;

import org.junit.Before;
import org.junit.Test;

public class OlxHomePageTest extends SeleniumBaseTest {
    private OlxHomePage olxHomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        olxHomePage = new OlxHomePage (webDriver);
        webDriver.get("https://www.olx.pl/");
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void assertOlxResult () {
        olxHomePage.clickFarmingCategory()
                    .clickTractors()
                    .checkPhotoOnly()
                    .fillCityForSearch("Mazowieckie")
                    .fillPriceFrom("13000")
                    .fillPriceTo("45000")
                    .assertOffer1("21 000");

    }

}
