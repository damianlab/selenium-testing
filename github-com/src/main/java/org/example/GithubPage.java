package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GithubPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public GithubPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GithubPage inputTextForSearch (String textForSearch) {
        searchField.clear();
        searchField.sendKeys(textForSearch);
        return this;
    }

    public GithubSearchResultPage submitTextForSearch () {
        Actions clickEnter = new Actions(webDriver);
        clickEnter.sendKeys(Keys.ENTER).build().perform();
        return new GithubSearchResultPage(webDriver);

    }
}
