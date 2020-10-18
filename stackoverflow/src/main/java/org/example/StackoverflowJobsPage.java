package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StackoverflowJobsPage extends AbstractPage{

    @FindBy (xpath = "(//input[@type='text'])[2]")
    WebElement jobTitle;

    @FindBy (xpath = "(//div[@class='s-navigation ai-center mb8']/a)[2]")
    WebElement companies;

    @FindBy (xpath = "/html/body/div[3]/div[2]/div[3]/form/div[1]/div[1]/div[2]/div[1]/input")
    WebElement location;

    public StackoverflowJobsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StackoverflowJobsPage inputJobTitleForSearch (String jobTitleForSearch) {
        wait.until(ExpectedConditions.visibilityOf(jobTitle));
        jobTitle.click();
        jobTitle.clear();
        jobTitle.sendKeys(jobTitleForSearch);
        return this;
    }

    public StackoverflowJobsPage inputLocationSearch () {
        wait.until(ExpectedConditions.visibilityOf(location));
        location.click();
        location.click();
        location.sendKeys("London");
        return this;
    }

    public StackoverflowJobsPage clickCompanies () {
        wait.until(ExpectedConditions.elementToBeClickable(companies));
        companies.click();
        return this;
    }

}
