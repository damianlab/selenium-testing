package org.example;

import org.junit.Before;
import org.junit.Test;

public class CheckboxesPageTest extends SeleniumBaseTest {

    private CheckboxesPage checkboxesPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        checkboxesPage = new CheckboxesPage (webDriver);
        webDriver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void givenPageIsLoadedThenCheckbox2IsSelected () {
        checkboxesPage
                .assertThatCheckbox2IsSelected();
    }

    @Test
    public void givenCheckbox1IsClickedThenCheckbox1And2IsSelected () {
        checkboxesPage
                .clickCheckbox1()
                .assertThatCheckbox1IsSelected()
                .assertThatCheckbox2IsSelected();
    }

    @Test
    public void givenCheckbox1IsClickedAndCheckbox2IsUnclickedThenCheckbox1IsSelectedAndCheckbox2IsNotSelected () {
        checkboxesPage
                .clickCheckbox1()
                .clickCheckbox2()
                .assertThatCheckbox1IsSelected()
                .assertThatCheckbox2IsNotSelected();
    }

}
