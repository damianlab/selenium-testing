package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OlxHomePage extends AbstractPage{

    @FindBy (xpath = "//a[@data-id='757']")
    WebElement categoryFarming;

    public OlxHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public OlxHomePage clickFarmingCategory() {
        categoryFarming.click();
        return this;
    }

    public OlxTractorsPage clickTractors () {
        //WebElement tractors = webDriver.findElement(By.xpath("//a[@data-id='1175']"));
        WebElement tractors = webDriver.findElement(By.xpath("//div[@id='bottom757']/ul/li[1]/a"));
        tractors.sendKeys(Keys.ENTER);
        return new OlxTractorsPage(webDriver);

    }

}
