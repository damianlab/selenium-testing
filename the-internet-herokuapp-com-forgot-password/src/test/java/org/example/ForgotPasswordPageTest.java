package org.example;

import org.junit.Before;
import org.junit.Test;

public class ForgotPasswordPageTest extends SeleniumBaseTest {

    private ForgotPasswordPage forgotPasswordPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/forgot_password");
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
