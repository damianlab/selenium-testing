package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TranslateEnToPlPageTest extends SeleniumBaseTest{
    private TranslateEnToPlPage translateEnToPlPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        translateEnToPlPage = new TranslateEnToPlPage(webDriver);
        webDriver.get("https://translate.google.com/?hl=pl#view=home&op=translate&sl=en&tl=pl&text=good%20morning");
    }

    @Test
    public void assertTranslation () {
        translateEnToPlPage
                .clearTextField()
                .enterTextForTranslation()
                .assertTranslationIsCorrect();

        }

    }
