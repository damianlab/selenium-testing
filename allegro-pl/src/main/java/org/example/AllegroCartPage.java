package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroCartPage extends AbstractPage{

    @FindBy(xpath = "//div[@data-role='cart-quantity']")
    private WebElement numberOfItemsInTheCart;

    public AllegroCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroCartPage assertNumberOfItemsInTheCart (int expectedNumberOfItems) {
        wait.until(ExpectedConditions.visibilityOf(numberOfItemsInTheCart));
        //Assertions.assertThat(numberOfItemsInTheCart.getText()).isEqualTo(expectedNumberOfItems);
        Assertions.assertThat(Integer.valueOf(numberOfItemsInTheCart.getText())).isEqualTo(expectedNumberOfItems);
        return this;
    }

}
