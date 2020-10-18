package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class InstagramUserPage extends AbstractPage{
    @FindBy (xpath = "//button[text()= 'Nie teraz']")
    WebElement buttonNotNow;

    @FindBy (xpath = "//h4[text()= 'Propozycje dla Ciebie']")
    WebElement textOnTop;

    public InstagramUserPage(WebDriver webDriver) {
        super(webDriver);
    }

public InstagramUserHomePage clickButtonNotNow () {
    //WebElement buttonNotNow = webDriver.findElement(By.xpath("//button[text()= 'Nie teraz']"));
    wait.until(ExpectedConditions.elementToBeClickable(buttonNotNow));
    System.out.println("This is button text: " + buttonNotNow.getText());
    wait.withTimeout(Duration.ofSeconds(5000));
    buttonNotNow.click();
    buttonNotNow.click();
    return new InstagramUserHomePage(webDriver);
}

public InstagramUserPage assertText (String text) {
        wait.until(ExpectedConditions.visibilityOf(textOnTop));
    Assertions.assertThat(textOnTop.getText()).isEqualTo(text);
    return this;
}
}
