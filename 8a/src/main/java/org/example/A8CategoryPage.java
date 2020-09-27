package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class A8CategoryPage extends AbstractPage{
    public A8CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

public A8MeansJacketsPage clickMeansJacketsCategory () {
        WebElement meansJackets = webDriver.findElement(By.xpath("(//form[@data-amshopby-filter='attr_category_ids']/ul/li)[1]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(meansJackets));
        meansJackets.click();
        return new A8MeansJacketsPage(webDriver);
}

}
