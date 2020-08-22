package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroCartPage extends AbstractPage{

    @FindBy(xpath = "//div[@data-role='cart-quantity']")
    private WebElement cartNumberOfItems;

    public AllegroCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroCartPage assertCartNumberOfItems (int expectedCartItems) {
        wait.until(ExpectedConditions.visibilityOf(cartNumberOfItems));
        Assertions.assertThat(Integer.valueOf(cartNumberOfItems.getText())).isEqualTo(expectedCartItems);
        return this;

    }
}
