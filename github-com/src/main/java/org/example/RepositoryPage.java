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

    @FindBy(xpath = "//div[@role='row']")
    private List<WebElement> files;

    @FindBy(xpath = "//a[@class='link-gray-dark no-underline']/strong")
    private WebElement branches;

    @FindBy(xpath = "//a[@class='ml-3 link-gray-dark no-underline']/strong")
    private WebElement tags;

    @FindBy(xpath = "//div[@class='mt-3'][3]")
    private WebElement linkLicence;

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

    public RepositoryPage assertNumberOfFiles (int expectedFiles) {
        wait.until(ExpectedConditions.visibilityOfAllElements(files));
        Assertions.assertThat(files.size()).isEqualTo(expectedFiles);
        return this;
    }

    public RepositoryPage assertNumberOfBranches (int expectedBranches) {
        wait.until(ExpectedConditions.visibilityOf(branches));
        Assertions.assertThat(Integer.valueOf(branches.getText())).isEqualTo(expectedBranches);
        return this;
    }

    public RepositoryPage assertNumberOfTags (int expectedTags) {
        wait.until(ExpectedConditions.visibilityOf(tags));
        Assertions.assertThat(Integer.valueOf(tags.getText())).isEqualTo(expectedTags);
        return this;
    }

    public RepositoryPage assertLicenceText (String expectedLicenceText) {
        wait.until(ExpectedConditions.visibilityOf(linkLicence));
        Assertions.assertThat(linkLicence.getText()).isEqualTo(expectedLicenceText);
        return this;
    }
}
