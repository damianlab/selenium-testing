package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPage extends AbstractPage {

    @FindBy(xpath = "//input[1]")
    private WebElement checkbox1;

    @FindBy(xpath = "//input[2]")
    private WebElement checkbox2;

    public CheckboxesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckboxesPage clickCheckbox1 () {
        checkbox1.click();
        return this;

    }

    public CheckboxesPage clickCheckbox2 () {
        checkbox2.click();
        return this;
    }

    public CheckboxesPage assertThatCheckbox1IsSelected () {
        assertThat(checkbox1.isSelected()).isTrue();
        return this;
    }

    public CheckboxesPage assertThatCheckbox2IsSelected () {
        assertThat(checkbox2.isSelected()).isTrue();
        return this;
    }

    public CheckboxesPage assertThatCheckbox1IsNotSelected () {
        assertThat(checkbox1.isSelected()).isFalse();
        return this;
    }

    public CheckboxesPage assertThatCheckbox2IsNotSelected () {
        assertThat(checkbox2.isSelected()).isFalse();
        return this;
    }
}
