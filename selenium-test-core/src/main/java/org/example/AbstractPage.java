package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public AbstractPage wait(int seconds, TimeUnit timeUnit) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    protected void openInNewTab(WebElement webElement) {
        Actions openInNewTab = new Actions(webDriver);
        openInNewTab
                .moveToElement(webElement)
                .keyDown(Keys.LEFT_CONTROL).click().keyUp(Keys.LEFT_CONTROL)
                .build().perform();
    }

    protected void switchToSecondTab() {
        List<String> openedTabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(openedTabs.get(1));
    }

    protected void switchToFirstTab() {
        List<String> openedTabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(openedTabs.get(0));
    }

    protected void closeTab() {
        webDriver.close();
    }

}
