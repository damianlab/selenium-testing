package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InstagramSearchedProfilePage extends AbstractPage{
    @FindBy (xpath = "/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div/div/span/span[1]/button")
    WebElement follow;

    @FindBy (xpath = "(//header[@class='vtbgv ']/section[@class='zwlfE']/ul/li/span/span)[1]")
    WebElement posts;

    @FindBy (xpath = "(//header[@class='vtbgv ']/section[@class='zwlfE']/ul/li/a/span)[1]")
    WebElement followers;

    @FindBy (xpath = "(//header[@class='vtbgv ']/section[@class='zwlfE']/ul/li/a/span)[2]")
    WebElement followed;

    @FindBy (xpath = "(//div[@class='_9AhH0'])[1]")
    WebElement postPicture;

    @FindBy (xpath = "(//div[@class='Fifk5']/div)[1]")
    WebElement homeButton;

    public InstagramSearchedProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public InstagramSearchedProfilePage clickFollowButton () {
        wait.until(ExpectedConditions.elementToBeClickable(follow));
        try {
            follow.click();
        } catch (Exception e) {
            follow.click();
        }
        return this;
    }

    public InstagramSearchedProfilePage assertPostsNumber (int postsNumber) {
        wait.until(ExpectedConditions.visibilityOf(posts));
        int postOf = Integer.valueOf(posts.getText().replaceAll(" ",""));
        Assertions.assertThat(postOf).isEqualTo(postsNumber);
        return this;
    }

    public InstagramSearchedProfilePage assertFollowersByText (String followersText) {
        wait.until(ExpectedConditions.visibilityOf(followers));
        Assertions.assertThat(followers.getText()).isEqualTo(followersText);
        return this;
    }

    public InstagramSearchedProfilePage assertFollowersByNumber (double followersNumber) {
        double followersOf = Double.valueOf(followers.getText().replaceAll("tys.", "").replaceAll(",", "."));
        Assertions.assertThat(followersOf).isEqualTo(followersNumber);
        return this;
    }

    public InstagramSearchedProfilePage assertFollowedUsers (int followedNumber) {
        int followedOf = Integer.valueOf(followed.getText().replaceAll(" ",""));
        Assertions.assertThat(followedOf).isGreaterThan(followedNumber);
        return this;

    };

    public InstagramPostPage clickFirstPost () {
        postPicture.click();
        return new InstagramPostPage(webDriver);
    }

    public InstagramUserHomePage clickHomeButton () {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        return new InstagramUserHomePage(webDriver);

    }
}
