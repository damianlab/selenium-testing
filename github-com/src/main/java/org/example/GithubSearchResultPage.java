package org.example;

import org.assertj.core.api.BigDecimalAssert;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class GithubSearchResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='px-2']/div/h3")
    private WebElement searchResultCount;

    @FindBy(xpath = "(//a[@class='v-align-middle'])[1]")
    private WebElement linkToFirstRepository;

    public GithubSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GithubSearchResultPage assertSearchResultCount (BigDecimal bigDecimal) {
        wait.until(ExpectedConditions.visibilityOf(searchResultCount));

        String count = searchResultCount.getText().replace(" repository results", "").replace(",", "");
        new BigDecimalAssert(new BigDecimal(count)).isCloseTo(bigDecimal, Percentage.withPercentage(5));
        return this;
    }

    public RepositoryPage clickFirstRepositoryLink () {
        linkToFirstRepository.click();
        return new RepositoryPage(webDriver);
    }

}
