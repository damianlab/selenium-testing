package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordPageTest {

    private WebDriver webDriver;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() throws Exception {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/forgot_password");
    }

    @After
    public void tearDown() throws Exception {
        webDriver.close();
    }

    @Test
    public void givenEmailIsValidThenEmailSentPageIsShown() {
        forgotPasswordPage
                .inputEmail("test@gmail.com")
                .clickRetrievePasswordButton()
                .assertThatEmailSentPageIsShown()
                .assertThatContentIsShown();
    }

    @Test
    public void givenEmailIsNotValidThenInternalServerErrorIsShown() {
        forgotPasswordPage.clickRetrievePasswordButton();
        forgotPasswordPage.assertThatInternalServerErrorIsShown();
    }
}
