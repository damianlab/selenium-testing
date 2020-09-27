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
    public void assertOlxResult () throws InterruptedException {
        olxHomePage.clickFarmingCategory()
                    .clickTractors()
                    .checkPhotoOnly()
                    .fillCityForSearch("Mazowieckie")
                    .fillPriceFrom("13000")
                    .fillPriceTo("45000")
                    .fillPowerFrom("60")
                    .fillPowerTo("400")
                    .fillMotoHFrom("500")
                    .fillMotoHTo("3000")
                    .fillYearFrom("1990")
                    .fillYearTo("2007")
                    .assertOffer1(27500)
                    .assertNumberOfOffers(5)
                    .clickFirstOffer()
                    .assertProductionYear(1995)
                    .assertMotoH(3000)
                    .assertOfferUser("Krystian");

    }

}
