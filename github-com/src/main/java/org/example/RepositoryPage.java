package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BigDecimalAssert;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;

public class RepositoryPage extends AbstractPage{

    @FindBy(xpath = "//a[@class='social-count js-social-count']")
    private WebElement star;

    @FindBy(xpath = "//div[@class='BorderGrid-cell' and ./h2/text()='Languages']/ul/li")
    private List<WebElement> languages;

    public RepositoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public RepositoryPage assertStarValue (BigDecimal bigDecimal) {
        wait.until(ExpectedConditions.visibilityOf(star));

        String result = star.getText().replace("k", "");
        new BigDecimalAssert(new BigDecimal(result)).isCloseTo(bigDecimal, Percentage.withPercentage(5));
        return this;
    }

    public RepositoryPage assertNumberOfLanguages (int expectedLanguages) {
        wait.until(ExpectedConditions.visibilityOfAllElements(languages));

        Assertions.assertThat(languages.size()).isEqualTo(expectedLanguages);
        return this;
    }

}
