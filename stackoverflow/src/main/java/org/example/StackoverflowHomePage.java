package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StackoverflowHomePage extends AbstractPage{

    @FindBy (xpath = "//div[@class='grid--cell']/a[@aria-label='notice-dismiss']")
    WebElement notice;

    @FindBy (xpath = "/html/body/div[3]/div[2]/div[8]/div/div/div[1]/a[2]")
    WebElement jobs;


    public StackoverflowHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public StackoverflowHomePage clickCloseNotice () {
        notice.click();
        return this;
    }

    public StackoverflowHomePage scrollPage () {
        Actions actions = new Actions(webDriver);
        // Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        return this;
    }
    public StackoverflowJobsPage clickJobsLink () {
        wait.until(ExpectedConditions.elementToBeClickable(jobs));
        //jobs.click();
        jobs.click();
        ArrayList<String> handles = new ArrayList<String>(webDriver.getWindowHandles());
        System.out.println("strony: " + handles);
        webDriver.switchTo().window(handles.get(1));
        return new StackoverflowJobsPage(webDriver);
    }

}
