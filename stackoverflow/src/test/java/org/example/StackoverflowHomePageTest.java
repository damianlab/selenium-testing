package org.example;

import org.junit.Before;
import org.junit.Test;

public class StackoverflowHomePageTest extends SeleniumBaseTest{

    StackoverflowHomePage stackoverflowHomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        stackoverflowHomePage = new StackoverflowHomePage(webDriver);
        webDriver.get("https://stackoverflow.com");
    }

    @Override
    public void tearDown() {

    }
    @Test
    public void stackcverflowPageTest () {
        stackoverflowHomePage.clickCloseNotice()
                .scrollPage()
                .clickJobsLink()
                //.clickCompanies();
                //.inputJobTitleForSearch("Web developer")
                .inputLocationSearch();
    }

}
