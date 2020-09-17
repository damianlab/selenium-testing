package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OlxTractorsPage extends AbstractPage{

    @FindBy (xpath = "(//span[@class='header block'])[1]")
    WebElement priceFieldFrom;

    @FindBy (xpath = "(//span[@class='header block'])[2]")
    WebElement priceFieldTo;

    @FindBy (xpath = "/html/body/div[2]/header/div[2]/div/form/fieldset/div/noindex/table/tbody/tr/td[2]/div/div/div/input[1]")
    WebElement cityForSearch;

    @FindBy (xpath = "//label[@for='photo-only']")
    WebElement photoOnly;

    public OlxTractorsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OlxTractorsPage fillCityForSearch (String city) {
        wait.until(ExpectedConditions.visibilityOf(cityForSearch));
        cityForSearch.sendKeys(city);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'autosuggest-geo-div')]/ul/li/a")));
        webDriver.findElement(By.xpath("(//div[contains(@class, 'autosuggest-geo-div')]/ul/li/a)[1]")).click();

        return this;
    }
    public OlxTractorsPage fillPriceFrom (String priceFromValue) {
        //WebElement priceField = webDriver.findElement(By.xpath("(//a[@class='button button-from numeric gray block fnormal rel zi3 clr'])[1]"));
        //wait.until(ExpectedConditions.visibilityOf(priceFieldFrom));
        //priceField.sendKeys(priceFromValue);
        //priceField.submit();
        //System.out.println(priceFieldFrom.getText());
        //priceFieldFrom.click();
        WebElement priceField = webDriver.findElement(By.xpath("//li[@id='param_price']/div/div/a/span[@data-default-label='od']"));
        wait.until(ExpectedConditions.elementToBeClickable(priceField));
        priceField.click();
        new Actions(webDriver).sendKeys(priceFromValue).sendKeys(Keys.ENTER).build().perform();
        return this;

    }

    public OlxTractorsPage fillPriceTo (String priceToValue) {
        WebElement priceField = webDriver.findElement(By.xpath("//li[@id='param_price']/div/div/a/span[@data-default-label='do']"));
        wait.until(ExpectedConditions.elementToBeClickable(priceField));
        priceField.click();
        new Actions(webDriver).sendKeys(priceToValue).sendKeys(Keys.ENTER).build().perform();
        return this;

    }

    public OlxTractorsPage checkPhotoOnly () {
        wait.until(ExpectedConditions.visibilityOf(photoOnly));
        photoOnly.click();
        return this;
    }

    public OlxTractorsPage assertOffer1 (String tractor1Price) {
        WebElement offerTractor1Price = webDriver.findElement(By.xpath("(//table[@id='offers_table']/tbody/tr[@class='wrap'])[1]/td/div/table/tbody/tr/td[contains(@class, 'td-price')]/div/p/strong"));
        wait.until(ExpectedConditions.visibilityOf(offerTractor1Price));
        System.out.println(offerTractor1Price.getText());
        Assertions.assertThat(offerTractor1Price.getText()).isEqualTo(tractor1Price);
        return this;
    }
}
