package org.example;

import org.junit.Before;
import org.junit.Test;

public class GmailAboutPageTest extends SeleniumBaseTest {
    private GmailAboutPage gmailAboutPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        gmailAboutPage = new GmailAboutPage(webDriver);
        webDriver.get("https://www.google.com/gmail/about/");
    }

    @Test
    public void assertPageTitle () {
        gmailAboutPage
                .assertThatGmailAboutPageIsShown();
    }
}
