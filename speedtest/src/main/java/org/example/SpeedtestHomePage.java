package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpeedtestHomePage extends AbstractPage{

    @FindBy(xpath = "(//a[@class='close-btn'])[4]")
    WebElement privacyPolicy;

    @FindBy(xpath = "//div[@class='start-button']/a")
    WebElement goButton;

    public SpeedtestHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SpeedtestHomePage closePrivacyPolicy () {
        privacyPolicy.click();
        return this;
    }

    public SpeedtestHomePage runTheTest () {
        goButton.click();
        return this;
    }

    public SpeedtestHomePage readTheTestResults () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result-label']")));
        WebElement pingResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left'])[1]"));
        System.out.println("Result" + pingResult.getText());
        return this;
    }

}
