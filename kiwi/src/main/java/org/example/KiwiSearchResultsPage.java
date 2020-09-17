package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KiwiSearchResultsPage extends AbstractPage{

    @FindBy(xpath = ("(//div[@data-test='ResultCardWrapper'])[1]"))
    private WebElement result1;

    public KiwiSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public KiwiSearchResultsPage openResults1Details () {
        wait.until(ExpectedConditions.visibilityOf(result1));
        result1.click();
        return this;
    }

    public KiwiSearchResultsPage readFlightDetails () {
        WebElement departureTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[1]"));
        System.out.println(departureTime.getText());
        WebElement departureAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[1]"));
        System.out.println(departureAirport.getText());
        WebElement arrivalTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[2]"));
        System.out.println(arrivalTime.getText());
        WebElement arrivalAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[2]"));
        System.out.println(arrivalAirport.getText());
        WebElement flightAirlines = webDriver.findElement(By.xpath("(//div[contains(@class, 'Stack__StyledStack')]/div/div/div)[10]"));
        System.out.println(flightAirlines.getText());

        WebElement returnFlightDepartureTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[3]"));
        System.out.println(returnFlightDepartureTime.getText());
        WebElement returnDepartureAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[3]"));
        System.out.println(returnDepartureAirport.getText());
        WebElement returnArrivalTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[4]"));
        System.out.println(returnArrivalTime.getText());
        WebElement returnArrivalAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[4]"));
        System.out.println(returnArrivalAirport.getText());
        WebElement returnFlightAirlines = webDriver.findElement(By.xpath("(//div[contains(@class, 'Stack__StyledStack')]/div/div/div)[12]"));
        System.out.println(returnFlightAirlines.getText());
        return this;
    }

    public KiwiSearchResultsPage assertFlightDepartureTime (String expectedDepartureTime) {
        WebElement departureTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[1]"));
        Assertions.assertThat(departureTime.getText()).isEqualTo(expectedDepartureTime);
        return this;
    }

    public KiwiSearchResultsPage assertFlightDepartureAirport (String expectedDepartureAirport) {
        WebElement departureAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[1]"));
        Assertions.assertThat(departureAirport.getText()).isEqualTo(expectedDepartureAirport);
        return this;
    }

    public KiwiSearchResultsPage assertFlightAirlines (String expectedAirlines) {
        WebElement flightAirlines = webDriver.findElement(By.xpath("(//div[contains(@class, 'Stack__StyledStack')]/div/div/div)[10]"));
        Assertions.assertThat(flightAirlines.getText()).isEqualTo(expectedAirlines);
        return this;
    }

    public KiwiSearchResultsPage assertArrivalTime (String expectedArrivalTime) {
        WebElement arrivalTime = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripDetail')]/div/div/strong/time)[2]"));
        Assertions.assertThat(arrivalTime.getText()).isEqualTo(expectedArrivalTime);
        return this;

    }

    public KiwiSearchResultsPage assertArrivalAirport (String expectedArrivalAirport) {
        WebElement arrivalAirport = webDriver.findElement(By.xpath("(//div[contains(@class, 'ResultDetailstyled__TripCell')]/div/div/h4)[2]"));
        Assertions.assertThat(arrivalAirport.getText()).isEqualTo(expectedArrivalAirport);
        return  this;
    }


}
