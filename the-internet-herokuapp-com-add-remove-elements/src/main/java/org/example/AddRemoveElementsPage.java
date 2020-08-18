package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddRemoveElementsPage extends AbstractPage {

    @FindBy(xpath = ("//div[@class='example']/button"))
    private WebElement addElement;

    public AddRemoveElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddRemoveElementsPage addElement () {
        addElement.click();
        return this;
    }

    public AddRemoveElementsPage deleteButton (int number) {
        WebElement button = webDriver.findElement(By.xpath("//div[@id='elements']/button[" + number + "]"));
        button.click();
        return this;
    }

    public AddRemoveElementsPage assertThatAddRemoveElementPageIsShown() {
        //WebElement error = webDriver.findElement(By.xpath("//h1"));
        assertThat(webDriver.getCurrentUrl()).isEqualTo("http://the-internet.herokuapp.com/add_remove_elements/");
        return this;
    }

    public AddRemoveElementsPage assertButtonContent () {
        //assertThat(content.getText()).isEqualTo("Your e-mail's been sent!");
        assertThat(addElement.getText()).isEqualTo("Add Element");
        return this;
    }

    public AddRemoveElementsPage assertButtonDisplayed (int number) {
        List<WebElement> button = webDriver.findElements(By.xpath("//div[@id='elements']/button[" + number + "]"));
        assertThat(button.isEmpty()).isFalse();
        return this;
    }

    public AddRemoveElementsPage assertButtonIsDeleted(int number) {
        List<WebElement> button = webDriver.findElements(By.xpath("//div[@id='elements']/button[" + number + "]"));
        assertThat(button.isEmpty()).isTrue();
        return this;
    }


}
