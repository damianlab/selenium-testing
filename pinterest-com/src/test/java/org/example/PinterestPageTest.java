package org.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PinterestPageTest extends SeleniumBaseTest {
    private PinterestPage pinterestPage;

@Override
    public void setUp() throws Exception {
    super.setUp();

    pinterestPage = new PinterestPage(webDriver);
    webDriver.get("https://www.pinterest.co.uk/");
}

@Test
    public void clickLogIn () {
    pinterestPage.logIn()
            .clickLogInButton()
            .assertInfoText("What is that?");

}

}
