package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailSentPage extends AbstractPage {

    @FindBy(id = "content")
    private WebElement content;

    public EmailSentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EmailSentPage assertThatEmailSentPageIsShown() {
        assertThat(webDriver.getCurrentUrl()).isEqualTo("http://the-internet.herokuapp.com/email_sent");
        return this;
    }

    public EmailSentPage assertThatContentIsShown() {
        assertThat(content.getText()).isEqualTo("Your e-mail's been sent!");
        return this;
    }

}
