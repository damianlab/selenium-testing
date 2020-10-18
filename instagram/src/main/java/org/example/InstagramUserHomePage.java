package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.Keys.ENTER;

public class InstagramUserHomePage extends AbstractPage{
    @FindBy (xpath = "//input[@placeholder='Szukaj']")
    WebElement searchField;

    public InstagramUserHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public InstagramSearchedProfilePage enterSearchText (String searchText) {
        searchField.sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drKGC']/div[@class='fuqBx']/a")));
        WebElement click = webDriver.findElement(By.xpath("//div[@class='drKGC']/div[@class='fuqBx']/a"));
        click.click();
        return new InstagramSearchedProfilePage(webDriver);
    }

}
