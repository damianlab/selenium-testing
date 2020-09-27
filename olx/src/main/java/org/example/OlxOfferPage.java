package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OlxOfferPage extends AbstractPage{

    public OlxOfferPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OlxOfferPage assertProductionYear (Integer year) throws InterruptedException {
        Thread.sleep(5000);
        WebElement offerDetailsYearOfProduction = webDriver.findElement(By.xpath("(//ul[@class='offer-details']/li)[3]/span/strong"));
        int yearOfProduction = Integer.parseInt(offerDetailsYearOfProduction.getText().replaceAll(" ",""));
        Assertions.assertThat(yearOfProduction).isEqualTo(year);
        return this;
    }

    public OlxOfferPage assertMotoH (Integer hrs) {
        WebElement offerDetailsMotoH = webDriver.findElement(By.xpath("(//ul[@class='offer-details']/li)[5]/span/strong"));
        int motoHOfProduct = Integer.parseInt(offerDetailsMotoH.getText().replaceAll(" ", ""));
        Assertions.assertThat(motoHOfProduct).isEqualTo(hrs);
        return this;
    }

    public OlxOfferPage assertOfferUser (String name) {
        WebElement offerUserName = webDriver.findElement(By.xpath("//div[@class='offer-user__details ']/div[2]/h4/a"));
        Assertions.assertThat(offerUserName.getText()).isEqualTo(name);
        return this;
    }

}
