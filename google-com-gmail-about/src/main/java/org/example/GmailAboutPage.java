package org.example;

import org.assertj.core.api.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GmailAboutPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='h-c-button h-c-button--primary hero-carousel__cta hero-carousel__cta--reg']")
    private WebElement createAccountButton;

    public GmailAboutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GmailAboutPage assertThatGmailAboutPageIsShown () {
        webDriver.getCurrentUrl();
        String expectedTitle = "Gmail – poczta według Google";
        String actualTitle = webDriver.getTitle();
        //assertThat(addElement.getText()).isEqualTo("Add Element");
        //assertThat(webDriver.getCurrentUrl()).isEqualTo("http://the-internet.herokuapp.com/add_remove_elements/");
        assertThat(actualTitle).isEqualTo(expectedTitle);
        return this;
    }


}
