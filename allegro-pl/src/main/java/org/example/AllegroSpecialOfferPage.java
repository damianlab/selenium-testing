package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroSpecialOfferPage extends AbstractPage{

    @FindBy(xpath = "//a[@data-analytics-view-custom-title='Elektronika']")
    private WebElement linkToElectronic;

    public AllegroSpecialOfferPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroElectronicPage clickLinkToElectronic () {
        wait.until(ExpectedConditions.elementToBeClickable(linkToElectronic));
        linkToElectronic.click();
        return new AllegroElectronicPage(webDriver);

    }
}
