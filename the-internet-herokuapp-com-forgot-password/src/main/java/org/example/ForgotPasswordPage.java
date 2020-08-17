package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ForgotPasswordPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "form_submit")
    private WebElement retrievePasswordButton;

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ForgotPasswordPage inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public EmailSentPage clickRetrievePasswordButton() {
        retrievePasswordButton.click();
        return new EmailSentPage(webDriver);
    }

    public ForgotPasswordPage assertThatInternalServerErrorIsShown() {
        WebElement error = webDriver.findElement(By.xpath("//h1"));
        assertThat(error.getText()).isEqualTo("Internal Server Error");
        return this;
    }
}
