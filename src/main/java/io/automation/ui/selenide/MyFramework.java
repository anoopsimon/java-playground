package io.automation.ui.selenide;


import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.ElementFinder;
import org.openqa.selenium.By;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.WebDriverRunner.driver;

public final class MyFramework {

    public static void setUp()
    {
        //Commands.getInstance().add("tripleClick", new TripleClick());
        Commands.getInstance().add("quadrupleClick", new QuadrupleClick());
    }

    /**
     * Replacement for standard Selenide `$` method.
     *
     * @param selector CSS selector
     *
     * @return MySelenideElement - an "advanced" version of `SelenideElement` with more custom methods
     */
    public static BrowserWrapper $$(String selector)
    {
        return ElementFinder.wrap(driver(), BrowserWrapper.class, null, By.cssSelector(selector), 0);
    }

    /**
     * Replacement for standard Selenide `$` method.
     *
     * @param selector By
     *
     * @return MySelenideElement - an "advanced" version of `SelenideElement` with more custom methods
     */
    public static BrowserWrapper $$(By selector) {
        return ElementFinder.wrap(driver(), BrowserWrapper.class, null, selector, 0);
    }
}