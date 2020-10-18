package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InstagramOnetapPage extends AbstractPage {

    public InstagramOnetapPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InstagramUserPage clickButton () {
        WebElement button = webDriver.findElement(By.xpath("(//button[@type='button'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        return new InstagramUserPage(webDriver);
    }
}
