package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroProductPage extends AbstractPage{

    @FindBy(xpath = "//button[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public AllegroProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroProductPage addProductToCart () {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public AllegroElectronicPage returnToElectronicPage() {
        closeTab();
        switchToFirstTab();
        return new AllegroElectronicPage(webDriver);
    }
}
