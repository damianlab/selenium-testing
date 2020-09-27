package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class A8MeansProductsPage extends AbstractPage{
    public A8MeansProductsPage(WebDriver webDriver) {
        super(webDriver);
    }
    public A8CategoryPage clickMeansCloth () {
        WebElement meansClothCategory = webDriver.findElement(By.xpath("(//form[@data-amshopby-filter='attr_category_ids']/ul/li)[1]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(meansClothCategory));
        meansClothCategory.click();
        return new A8CategoryPage(webDriver);
    }

}
