package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WizzairHomePage extends AbstractPage{

@FindBy(xpath = "//button[@class='cookie-policy__button']")
private WebElement popupButton;


    public WizzairHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WizzairHomePage clickPopUpButton () {
        wait.until(ExpectedConditions.visibilityOf(popupButton));
        popupButton.click();
        return this;
    }

}
