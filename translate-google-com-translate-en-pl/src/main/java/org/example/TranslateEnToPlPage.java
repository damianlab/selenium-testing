package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;


public class TranslateEnToPlPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@id='source']")
    private WebElement sourceTextField;

    public TranslateEnToPlPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TranslateEnToPlPage enterTextForTranslation (String text) {
        sourceTextField.sendKeys(text);
        return this;
    }

    public TranslateEnToPlPage clearTextField () {
        sourceTextField.clear();
        return this;
    }

    public TranslateEnToPlPage assertTranslationIsCorrect (String correctTranslation) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tlid-translation translation']")));
        WebElement translation = webDriver.findElement(By.xpath("//span[@class='tlid-translation translation']"));

        assertThat(translation.getText()).isEqualTo(correctTranslation);
        return this;

    }
}
