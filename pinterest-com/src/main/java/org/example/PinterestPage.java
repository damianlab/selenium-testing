package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class PinterestPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='Gd1 VxL hjj n9m zI7 iyn Hsu']")
    private WebElement logInButton;



    public PinterestPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PinterestPage logIn () {
        logInButton.click();
        // WebElement button = webDriver.findElement(By.xpath("//div[@id='elements']/button[" + number + "]"));
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys("adam.arcsortki@gmail.com");
        wait(5, TimeUnit.SECONDS);
        return this;
    }

    public PinterestPage clickLogInButton () {
        WebElement logInButton = webDriver.findElement(By.xpath("//button[@class='red SignupButton active']"));
        logInButton.click();
        wait(30, TimeUnit.SECONDS);
        return this;
    }

    public PinterestPage assertInfoText (String expectedInfoText) {
        WebElement infoText = webDriver.findElement(By.xpath("//span[@id='email-error']"));
        Assertions.assertThat(infoText.getText()).isEqualTo(expectedInfoText);
        return this;
    }
}
