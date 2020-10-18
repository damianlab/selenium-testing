package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InstagramPostPage extends AbstractPage{

    @FindBy (xpath = "//section[@class='ltpMr Slqrh']/span/button/div[@class='QBdPU ']/span")
    WebElement likeButton;

    @FindBy (xpath = "//div[@class='DdSX2']/a[@class=' _65Bje  coreSpriteRightPaginationArrow']")
    WebElement arrowNext;

    @FindBy (xpath = "/html/body/div[4]/div[2]/div/article/div[3]/section[3]/div/form/textarea")
    WebElement comments;

    public InstagramPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InstagramPostPage likePost () {
        wait.until(ExpectedConditions.elementToBeClickable(likeButton));
        likeButton.click();
        return this;
    }

    public InstagramPostPage addComments (String text) {
        wait.until(ExpectedConditions.visibilityOf(comments));
        comments.click();
        comments.sendKeys(text);
        WebElement button = webDriver.findElement(By.xpath("//section[@class='sH9wk  _JgwE ']/div/form/button"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        return this;
    }

    public InstagramPostPage goToNextPost () {
        wait.until(ExpectedConditions.elementToBeClickable(arrowNext));
        arrowNext.click();
        return new InstagramPostPage(webDriver);
    }

    public InstagramSearchedProfilePage closePostView () {
        WebElement closeButton = webDriver.findElement(By.xpath("//div[4]/div[3]/button/div"));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
        return new InstagramSearchedProfilePage(webDriver);
    }


}
