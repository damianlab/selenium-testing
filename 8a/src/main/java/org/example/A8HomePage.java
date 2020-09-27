package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class A8HomePage extends AbstractPage{

    @FindBy (xpath = "//div[@class='actions']/button[@id='btn-cookie-allow']")
    WebElement cookie;

    @FindBy (xpath = "//nav[@class='navigation']/ul[@class='megamenu-items'][1]/li[1]")
    WebElement mensCategoryLi;

    public A8HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public A8HomePage confirmCookie () {
        wait.until(ExpectedConditions.elementToBeClickable(cookie));
        cookie.click();
        return this;
    }

    public A8MeansProductsPage clickMensMenu() {
        //Actions actions = new Actions(webDriver);
        //actions.moveToElement(mensCategoryLi).build().perform();
        mensCategoryLi.click();
        return new A8MeansProductsPage(webDriver);
    }

}
