package org.example;

import javafx.util.converter.IntegerStringConverter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(text(),'do strefy okazji')]")
    private WebElement specialOffer;

    @FindBy(xpath = "//div[@data-role='cart-quantity']")
    private WebElement mainPageCartNumberOfItems;


    public AllegroPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroSpecialOfferPage clickOnSpecialOfferLink () {
        specialOffer.click();
        return new AllegroSpecialOfferPage(webDriver);
    }

    public AllegroPage closePopUpWindow () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-role='close-and-accept-consent']")));
        WebElement popUpButton = webDriver.findElement(By.xpath("//button[@data-role='close-and-accept-consent']"));
        popUpButton.click();
        return this;
    }

    public AllegroPage assertMainPageCartNumberOfItems (int expectedMainPageExpectedNumberOfItems) {
        wait.until(ExpectedConditions.visibilityOf(mainPageCartNumberOfItems));
        Assertions.assertThat(Integer.valueOf(mainPageCartNumberOfItems.getText())).isEqualTo(expectedMainPageExpectedNumberOfItems);
        return this;
    }

}
