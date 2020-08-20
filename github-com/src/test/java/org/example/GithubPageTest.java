package org.example;

import org.junit.Test;

import java.math.BigDecimal;

public class GithubPageTest  extends SeleniumBaseTest {
private GithubPage githubPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        githubPage = new GithubPage(webDriver);
        webDriver.get("https://github.com/");
    }

    @Test
    public void assertSearchResultValue () {
        githubPage.inputTextForSearch("java")
                .submitTextForSearch()
                .assertSearchResultCount(new BigDecimal("1541304"));

    }

    @Test
    public void assertSearchResultForSeleniumText () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .assertSearchResultCount(new BigDecimal("100"));
    }

    @Test
    public void assertFirstRepositoryStarsValue () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertStarValue(new BigDecimal("18.4"));
    }

    @Test
    public void assertNumberOfLanguages () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertNumberOfLanguages(7);
    }

    @Test
    public void assertNumberOfListedFiles () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertNumberOfFiles(42);
    }

    @Test
    public void assertNumberOfBranches () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertNumberOfBranches("15");

    }

    @Test
    public void assertNumberOfTags () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertNumberOfTags("125");

    }

    @Test
    public void assertLicenceText () {
        githubPage.inputTextForSearch("selenium")
                .submitTextForSearch()
                .clickFirstRepositoryLink()
                .assertLicenceText("Apache-2.0 License");
    }

}
