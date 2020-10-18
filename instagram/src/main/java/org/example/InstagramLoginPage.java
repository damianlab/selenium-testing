package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InstagramLoginPage extends AbstractPage{

    @FindBy (xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy (xpath = "//input[@name='password']")
    WebElement password;

    public InstagramLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InstagramLoginPage closePopUp () {
        WebElement popup = webDriver.findElement(By.xpath("//div[@role='dialog']/div/div/div/button[1]"));
        wait.until(ExpectedConditions.visibilityOf(popup));
        popup.click();
        return this;
    }
    public InstagramLoginPage enterUserName (String userNameLogIn) {
        userName.sendKeys(userNameLogIn);
        return this;
    }

    public InstagramLoginPage enterPassword (String passwordLogIn) {
        password.sendKeys(passwordLogIn);
        return this;
    }

    public InstagramOnetapPage clickLogIn () throws InterruptedException {
        //WebElement buttonSubmit = webDriver.findElement(By.xpath("//button[@type='submit' and contains(./div/text(), 'Zaloguj')]"));
        WebElement buttonSubmit = webDriver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]/button/div"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        Thread.sleep(5000);
        try {
            buttonSubmit.click();
            buttonSubmit.click();
        } catch (Exception e) {
        }
        return new InstagramOnetapPage(webDriver);
    }



    //pertostanec

    //gyb31311@eoopy.com

    //123#Asd
}
