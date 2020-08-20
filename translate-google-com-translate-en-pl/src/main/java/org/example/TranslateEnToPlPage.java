package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;


public class TranslateEnToPlPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@id='source']")
    private WebElement sourceTextField;

    public TranslateEnToPlPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TranslateEnToPlPage enterTextForTranslation () {
        sourceTextField.sendKeys("good morning");
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        //webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return this;
    }

    public TranslateEnToPlPage clearTextField () {
        sourceTextField.clear();
        return this;
    }
    public TranslateEnToPlPage assertTranslationIsCorrect () {
        //WebDriverWait wait = new WebDriverWait(webDriver, 5);
        //        wait.until((ExpectedCondition<Boolean>) driver -> inputField.isEnabled());
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        WebElement translation = webDriver.findElement(By.xpath("//span[@class='tlid-translation translation']"));
        assertThat(translation.getText()).isEqualTo("dzień dobry");
        return this;

    }
}
