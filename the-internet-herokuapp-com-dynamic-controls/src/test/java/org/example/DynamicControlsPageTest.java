package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPageTest extends SeleniumBaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        dynamicControlsPage = new DynamicControlsPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void checkboxExistsOnTheGivenPage () {
        dynamicControlsPage
                .assertThatCheckboxExists();
    }

    @Test
    public void checkboxIsDeletedByClickingAddOrRemoveButton () {
        dynamicControlsPage
                .assertThatCheckboxExists()
                .removeButtonClick()
                .assertThatCheckboxNotExists();
    }

    @Test
    public void checkboxWasDeletedAndAddedByClickingAddOrRemoveButton () {
        dynamicControlsPage
                .assertThatCheckboxExists()
                .removeButtonClick()
                .assertThatCheckboxNotExists()
                .removeButtonClick()
                .assertThatCheckboxExists();
    }

    @Test
    public void checkIfInputFieldIsDisable () {
        dynamicControlsPage
                .assertThatInputFieldIsDisabled();
    }

    @Test
    public void checkIfInputFieldIsEnableAfterClickingEnableButton () {
        dynamicControlsPage
                .assertThatInputFieldIsDisabled()
                .disableButtonClick()
                .assertThatInputFieldIsEnabled();

    }
}
