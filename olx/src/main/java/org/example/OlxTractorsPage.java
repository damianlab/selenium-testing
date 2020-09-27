package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

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

    public OlxTractorsPage fillPowerFrom (String powerFromValue) {
        WebElement powerField = webDriver.findElement(By.xpath("//li[@id='param_power']/div/div/a/span[@data-default-label='od']"));
        wait.until(ExpectedConditions.elementToBeClickable(powerField));
        powerField.click();
        new Actions(webDriver).sendKeys(powerFromValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public OlxTractorsPage fillPowerTo (String powerToValue) {
        WebElement powerField = webDriver.findElement(By.xpath("//li[@id='param_power']/div/div/a/span[@data-default-label='do']"));
        wait.until(ExpectedConditions.elementToBeClickable(powerField));
        powerField.click();
        new Actions(webDriver).sendKeys(powerToValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }


    public OlxTractorsPage fillMotoHFrom (String motoHFromValue) {
        WebElement motoHField = webDriver.findElement(By.xpath("//li[@id='param_motor_hours']/div/div/a/span[@data-default-label='od']"));
        wait.until(ExpectedConditions.elementToBeClickable(motoHField));
        motoHField.click();
        new Actions(webDriver).sendKeys(motoHFromValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public OlxTractorsPage fillMotoHTo (String motoHToValue) {
        WebElement motoHField = webDriver.findElement(By.xpath("//li[@id='param_motor_hours']/div/div/a/span[@data-default-label='do']"));
        wait.until(ExpectedConditions.elementToBeClickable(motoHField));
        motoHField.click();
        new Actions(webDriver).sendKeys(motoHToValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }


    public OlxTractorsPage fillYearFrom (String yearFromValue) {
        WebElement yearField = webDriver.findElement(By.xpath("//li[@id='param_year']/div/div/a/span[@data-default-label='od']"));
        wait.until(ExpectedConditions.elementToBeClickable(yearField));
        yearField.click();
        new Actions(webDriver).sendKeys(yearFromValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public OlxTractorsPage fillYearTo (String yearToValue) {
        WebElement yearField = webDriver.findElement(By.xpath("//li[@id='param_year']/div/div/a/span[@data-default-label='do']"));
        wait.until(ExpectedConditions.elementToBeClickable(yearField));
        yearField.click();
        new Actions(webDriver).sendKeys(yearToValue).sendKeys(Keys.ENTER).build().perform();
        return this;
    }





    public OlxTractorsPage checkPhotoOnly () {
        wait.until(ExpectedConditions.visibilityOf(photoOnly));
        photoOnly.click();
        return this;
    }

    public OlxTractorsPage assertOffer1 (Integer tractor1Price) throws InterruptedException {
        Thread.sleep(5000);

        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(30, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='offers_table']/tbody/tr[@class='wrap'])[1]/td/div/table/tbody/tr/td[contains(@class, 'td-price')]/div/p/strong")));
        WebElement offerTractor1Price = webDriver.findElement(By.xpath("(//table[@id='offers_table']/tbody/tr[@class='wrap'])[1]/td/div/table/tbody/tr/td[contains(@class, 'td-price')]/div/p/strong"));

        System.out.println(offerTractor1Price.getText());

        String s = offerTractor1Price.getText().replaceAll(" ", "");
        int offerPrice = Integer.parseInt(s.substring(0, s.length() - 2));
        Assertions.assertThat(offerPrice).isEqualTo(tractor1Price);

        return this;
    }

    public OlxTractorsPage assertNumberOfOffers (Integer numberOfOffers) throws InterruptedException {


        Thread.sleep(5000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='offers_table']/tbody/tr/td/div[@class='hasPromoted section clr']/p")));
        WebElement offersValue = webDriver.findElement(By.xpath("//table[@id='offers_table']/tbody/tr/td/div[@class='hasPromoted section clr']/p"));
        System.out.println(offersValue.getText());

        int offers = Integer.parseInt(offersValue.getText().split(" ")[1]);
        Assertions.assertThat(offers).isEqualTo(numberOfOffers);

        return this;
    }

    public OlxOfferPage clickFirstOffer () throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//table[@id='offers_table']/tbody/tr[@class='wrap'])[1]/td/div/table/tbody/tr/td/a)[1]")));
        WebElement offer1Link = webDriver.findElement(By.xpath("((//table[@id='offers_table']/tbody/tr[@class='wrap'])[1]/td/div/table/tbody/tr/td/a)[1]"));
        offer1Link.click();
        return new OlxOfferPage(webDriver);

    }
}
