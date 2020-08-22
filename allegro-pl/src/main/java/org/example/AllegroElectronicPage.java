package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroElectronicPage extends AbstractPage{

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[1]")
    private WebElement product1;

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[4]")
    private WebElement product4;

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[5]")
    private WebElement product5;

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[6]")
    private WebElement product6;

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[7]")
    private WebElement product7;

    @FindBy(xpath = "(//div/div/div[contains(@class, 'carousel-item')])[8]")
    private WebElement product8;

    @FindBy(xpath = "//a[@href='/koszyk']")
    private WebElement cartButton;



    public AllegroElectronicPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AllegroProductPage openProduct1InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product1));
        openInNewTab(product1);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct4InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product4));
        openInNewTab(product4);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct5InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product5));
        openInNewTab(product5);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct6InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product6));
        openInNewTab(product6);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct7InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product7));
        openInNewTab(product7);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct8InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product8));
        openInNewTab(product8);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroCartPage openCartPage () {
        cartButton.click();
        return new AllegroCartPage(webDriver);
    }



}
