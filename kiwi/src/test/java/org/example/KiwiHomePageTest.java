package org.example;

import org.junit.Before;
import org.junit.Test;

public class KiwiHomePageTest extends SeleniumBaseTest{
    private KiwiHomePage kiwiHomePage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        kiwiHomePage = new KiwiHomePage(webDriver);
        webDriver.get("https://www.kiwi.com/en/");
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void closePrivacyWindow () throws InterruptedException {
        kiwiHomePage.closePrivacyWindow()
                .closeOsloLocationAtFromField()
                .enterDepartureAirport("Berlin")
                .enterDestinationAirport("London")
                .openDepartureDatePicker()
                .pickDepartureDate("2020-09-10")
                .clickReturnDate()
                .pickReturnDate("2020-09-15")
                .setDate()
                .clickSearchButton()
                .openResults1Details()
                .readFlightDetails();
    }

    @Test
    public void assertFlightDetails () throws InterruptedException {
        kiwiHomePage.closePrivacyWindow()
                .closeOsloLocationAtFromField()
                .enterDepartureAirport("Berlin")
                .enterDestinationAirport("London")
                .openDepartureDatePicker()
                .pickDepartureDate("2020-09-11")
                .clickReturnDate()
                .pickReturnDate("2020-09-15")
                .setDate()
                .clickSearchButton()
                .openResults1Details()
                .assertFlightDepartureTime("07:05")
                .assertFlightDepartureAirport("Berlin")
                .assertArrivalTime("08:10")
                .assertArrivalAirport("London")
                .assertFlightAirlines("British Airways");
    }

}
