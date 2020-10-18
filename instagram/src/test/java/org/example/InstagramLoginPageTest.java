package org.example;

import org.junit.Before;
import org.junit.Test;

public class InstagramLoginPageTest extends SeleniumBaseTest{
    InstagramLoginPage instagramLoginPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        instagramLoginPage = new InstagramLoginPage(webDriver);
        webDriver.get("https://www.instagram.com");
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void instagramLogInTest () throws InterruptedException {
        instagramLoginPage.closePopUp()
                              //90mq@10minute-mail.com
                            .enterUserName("damian.arciszewski@gmail.com")
                            .enterPassword("xxxsd")
                            .clickLogIn()
                            .clickButton()
                            .clickButtonNotNow()
                            .enterSearchText("thehhubdotcom")
                            //.clickFollowButton()
                            .assertPostsNumber(1660)
                            .assertFollowersByText("118tys.")
                            .assertFollowersByNumber(118)
                            .assertFollowedUsers(2226)
                            .clickFirstPost()
                            .goToNextPost()
                            .goToNextPost()
                            .goToNextPost()
                            .likePost()
                            .addComments("Nice")
                           //.goToNextPost()
                           // .likePost()
                            //.addComments("Nice")
                            //.goToNextPost()
                            //.likePost()
                           // .addComments("Nice")
                            .closePostView()
                            .clickHomeButton();
    }


}
