package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.math.BigDecimal;
import java.time.Duration;

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
        wait.withTimeout(Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='result-data']/a)[1]")));
        WebElement resultID = webDriver.findElement(By.xpath("(//div[@class='result-data']/a)[1]"));
        System.out.println("Result: " + resultID.getText());
        WebElement pingResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[1]"));
        System.out.println("Ping Result: " + pingResult.getText());
        WebElement downloadResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[2]"));
        System.out.println("Download Result: " + downloadResult.getText());
        WebElement uploadResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[3]"));
        System.out.println("Upload Result: " + uploadResult.getText());
        return this;
    }

    public SpeedtestHomePage assertId (String testId) {
        WebElement resultID = webDriver.findElement(By.xpath("(//div[@class='result-data']/a)[1]"));
        System.out.println("Result: " + resultID.getText());
        Assertions.assertThat(resultID.getText()).isEqualTo(testId);
        return this;

    }

    public SpeedtestHomePage assertDownload (BigDecimal downloadSpeed) {
        WebElement downloadResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[2]"));
        System.out.println("Download Result: " + downloadResult.getText());
        BigDecimal download = new BigDecimal(downloadResult.getText());
        Assertions.assertThat(download).isCloseTo(downloadSpeed, Percentage.withPercentage(50));
        return this;
    }

    public SpeedtestHomePage assertPing (int pingSpeed) {
        WebElement pingResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[1]"));
        System.out.println("Ping Result: " + pingResult.getText());
        BigDecimal ping = new BigDecimal(pingResult.getText());
        Assertions.assertThat(ping).isCloseTo(BigDecimal.valueOf(pingSpeed),Percentage.withPercentage(50));
        return this;
    }

    public SpeedtestHomePage assertUpload (BigDecimal uploadSpeed) {
        WebElement uploadResult = webDriver.findElement(By.xpath("(//div[@class='result-data u-align-left']/span)[3]"));
        System.out.println("Upload Result: " + uploadResult.getText());
        BigDecimal upload = new BigDecimal(uploadResult.getText());
        Assertions.assertThat(upload).isCloseTo(uploadSpeed,Percentage.withPercentage(50));
        return this;
    }

//    public  SpeedtestHomePage readPingResults () {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='result-data u-align-left']/span)[1]")));
//        WebElement
//    }

}
