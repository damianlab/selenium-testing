package org.example;

import org.junit.Test;

public class AddRemoveElementsPageTest extends SeleniumBaseTest {

    private AddRemoveElementsPage addRemoveElementsPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        addRemoveElementsPage = new AddRemoveElementsPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void givenAddRemoveElementPageIsShown() {
    addRemoveElementsPage
            .assertThatAddRemoveElementPageIsShown()
            .assertButtonContent();
    }

    @Test
    public void button1ElementIsAddedAndIsEnabled() {
    addRemoveElementsPage
            .addElement()
            .assertButtonDisplayed(1);
    }

    @Test
    public void button1button2button3AreAddedAndAreEnabled() {
        addRemoveElementsPage
                .addElement()
                .addElement()
                .addElement()
                .assertButtonDisplayed(1)
                .assertButtonDisplayed(2)
                .assertButtonDisplayed(3);
    }

    @Test
    public void button1Button2Button3AreAddedAndButton3Button2AreDeleted() {
        addRemoveElementsPage
                .addElement()
                .addElement()
                .addElement()
                .assertButtonDisplayed(1)
                .assertButtonDisplayed(2)
                .assertButtonDisplayed(3)
                .deleteButton(1)
                .assertButtonIsDeleted(3);
    }
}
