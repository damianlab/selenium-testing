package org.example;

import org.junit.Test;

public class AllegroPageTest extends SeleniumBaseTest{
private AllegroPage allegroPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        allegroPage = new AllegroPage(webDriver);
        webDriver.get("https://allegro.pl/");
    }

    @Test
    public void confirmElectronicSpecialOfferPageIsShown () {
        allegroPage.closePopUpWindow()
                .clickOnSpecialOfferLink()
                .clickLinkToElectronic();
    }

    @Test
    public void confirmProduct1ShownInSecondTab () {
        allegroPage.closePopUpWindow()
                .clickOnSpecialOfferLink()
                .clickLinkToElectronic()
                .openProduct1InNewTab();
    }

    @Test
    public void test () {
        allegroPage.closePopUpWindow()
                .clickOnSpecialOfferLink()
                .clickLinkToElectronic()
                .openProduct1InNewTab()
                .addProductToCart()
                .returnToElectronicPage();
    }

    @Test
    public void addProduct4AndCheckCartContent () {
        allegroPage.closePopUpWindow()
                .clickOnSpecialOfferLink()
                .clickLinkToElectronic()
                .openProduct2InNewTab()
                .addProductToCart()
                .returnToElectronicPage()
                .openCartPage();
    }

    @Test
    public void mainPageCartTest () {
        allegroPage.closePopUpWindow()
                .assertCartNumberOfItems("");
    }

    @Test
    public void addItemsToCartAndConfirmCartStatus () {
        allegroPage.closePopUpWindow()
                .clickOnSpecialOfferLink()
                .clickLinkToElectronic()
                .openProduct1InNewTab()
                .addProductToCart()
                .returnToElectronicPage()
                .openProduct2InNewTab()
                .addProductToCart()
                .returnToElectronicPage()
//                .openProduct3InNewTab()
//                .addProductToCart()
//                .returnToElectronicPage()
                .openCartPage()
                .assertNumberOfItemsInTheCart(1);
    }

}
