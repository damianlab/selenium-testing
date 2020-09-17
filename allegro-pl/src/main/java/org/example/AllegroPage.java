package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(text(),'do strefy okazji')]")
    private WebElement specialOffer;

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div/nav/div[3]/div/div/a/div/img")
    private WebElement cartNumberOfItems;

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
    public AllegroPage assertCartNumberOfItems (String expectedCartItems) {
        wait.until(ExpectedConditions.visibilityOf(cartNumberOfItems));
        Assertions.assertThat(cartNumberOfItems.getText()).isEqualTo(expectedCartItems);
        return this;

    }
}
