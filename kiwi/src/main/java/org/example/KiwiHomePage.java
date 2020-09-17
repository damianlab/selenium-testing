package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KiwiHomePage extends AbstractPage{

    @FindBy(xpath = "/html/body/div[6]/div/div/span/div/div/div/div/div/div/section/div[2]/button[2]/div/div")
    private WebElement acceptButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/div")
    private WebElement closeOsloLocation;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/input")
    private WebElement fromField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/input")
    private WebElement toField;


    public KiwiHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public KiwiHomePage closePrivacyWindow () {
        wait.until(ExpectedConditions.visibilityOf(acceptButton));
        acceptButton.click();
        return this;
    }

    public KiwiHomePage closeOsloLocationAtFromField () {
        wait.until(ExpectedConditions.visibilityOf(closeOsloLocation));
        closeOsloLocation.click();
        return this;
    }

    public KiwiHomePage enterDepartureAirport (String departureLocation) throws InterruptedException {
        fromField.click();
        fromField.sendKeys(departureLocation);
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public KiwiHomePage enterDestinationAirport (String destinationLocation) throws InterruptedException {
        toField.click();
        toField.sendKeys(destinationLocation);
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public KiwiHomePage openDepartureDatePicker () {
        WebElement clickDepartureDate = webDriver.findElement(By.xpath("//input[@name='search-outboundDate']"));
        clickDepartureDate.click();
        return this;
    }

    public  KiwiHomePage pickDepartureDate (String date) {
        WebElement pickedDate = webDriver.findElement(By.xpath("//div[@data-type='DayContainer' and  @data-value='" + date + "']"));
        pickedDate.click();
        return this;
    }

    public KiwiHomePage clickReturnDate () {
        WebElement pickedReturnDate = webDriver.findElement(By.xpath("(//div[@data-test='DateValue'])[2]"));
        pickedReturnDate.click();
        return this;

    }

    public KiwiHomePage pickReturnDate (String pickReturnDate) {
        WebElement pickedDate = webDriver.findElement(By.xpath("//div[@data-type='DayContainer' and  @data-value='" + pickReturnDate + "']"));
        pickedDate.click();
        return this;
    }

    public KiwiHomePage setDate () {
        WebElement setDateClick = webDriver.findElement(By.xpath("//button[@data-test='SearchFormDoneButton']"));
        setDateClick.click();
        return this;
    }

    public KiwiSearchResultsPage clickSearchButton () {
        WebElement searchButton = webDriver.findElement(By.xpath("//a[@data-test='LandingSearchButton']"));
        searchButton.click();
        return new KiwiSearchResultsPage(webDriver);
    }


}
