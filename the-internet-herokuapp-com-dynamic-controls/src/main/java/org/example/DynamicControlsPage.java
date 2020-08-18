package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicControlsPage extends AbstractPage {

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    private WebElement addOrRemoveButton;

    @FindBy(xpath = "//form[@id='input-example']/button")
    private WebElement enableOrDisableButton;

    @FindBy(xpath = "//form[@id='input-example']/input")
    private WebElement inputField;

    public DynamicControlsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DynamicControlsPage removeButtonClick () {
        addOrRemoveButton.click();
        return this;
    }

    public DynamicControlsPage disableButtonClick () {
        enableOrDisableButton.click();
        return this;
    }

    public DynamicControlsPage assertThatCheckboxExists () {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        List<WebElement> checkbox = webDriver.findElements(By.id("checkbox"));
        assertThat(checkbox.isEmpty()).isFalse();
        return this;
    }

    public DynamicControlsPage assertThatCheckboxNotExists () {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        List<WebElement> checkbox = webDriver.findElements(By.id("checkbox"));
        assertThat(checkbox.isEmpty()).isTrue();
        return this;
    }



    public DynamicControlsPage clickCheckbox () {
        webDriver.findElement(By.id("checkbox")).click();
        return this;
    }

    public DynamicControlsPage assertThatInputFieldIsEnabled() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until((ExpectedCondition<Boolean>) driver -> inputField.isEnabled());
        assertThat(inputField.isEnabled()).isTrue();
        return this;
    }

    public DynamicControlsPage assertThatInputFieldIsDisabled() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until((ExpectedCondition<Boolean>) driver -> !inputField.isEnabled());
        assertThat(inputField.isEnabled()).isFalse();
        return this;
    }

}
