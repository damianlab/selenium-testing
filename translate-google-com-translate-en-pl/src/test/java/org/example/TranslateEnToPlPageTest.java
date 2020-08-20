package org.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class TranslateEnToPlPageTest extends SeleniumBaseTest{
    private TranslateEnToPlPage translateEnToPlPage;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        translateEnToPlPage = new TranslateEnToPlPage(webDriver);
        webDriver.get("https://translate.google.com/?hl=pl#view=home&op=translate&sl=en&tl=pl");
    }

    @Test
    public void assertTranslation () {
        translateEnToPlPage
                .clearTextField()
                .enterTextForTranslation("this")
                .assertTranslationIsCorrect("to");
        }
    }