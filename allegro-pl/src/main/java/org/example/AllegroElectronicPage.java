package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllegroElectronicPage extends AbstractPage{

//    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div/div[3]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/ul/li[4]/a")
//    private WebElement product1;

    @FindBy(xpath = "//div[@class='_3kk7b _07bcb_CWOtz _vnd3k _1h8s6 _1755t _1nucm _1iuj2 _07bcb_3q-O5'][1]")
    private WebElement product1;

    @FindBy(xpath = "//div[@class='_3kk7b _07bcb_CWOtz _vnd3k _1h8s6 _1755t _1nucm _1iuj2 _07bcb_3q-O5'][2]")
    private WebElement product2;

    @FindBy(xpath = "//div[@class='_3kk7b _07bcb_CWOtz _vnd3k _1h8s6 _1755t _1nucm _1iuj2 _07bcb_3q-O5'][3]")
    private WebElement product3;

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

    public AllegroProductPage openProduct2InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product2));
        openInNewTab(product2);
        switchToSecondTab();
        return new AllegroProductPage(webDriver);
    }

    public AllegroProductPage openProduct3InNewTab() {
        wait.until(ExpectedConditions.visibilityOf(product3));
        openInNewTab(product3);
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
