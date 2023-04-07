package io.automation.ui.assertion;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

public class WebDriverAssert<T> extends AbstractAssert<WebDriverAssert<T>, WebDriver> {

    public WebDriverAssert(WebDriver actual) {
        super(actual, WebDriverAssert.class);
    }

    public static WebDriverAssert assertThat(WebDriver actual) {
        return new WebDriverAssert(actual);
    }

    public WebDriverAssert hasTitle(String title) {
        isNotNull();

        String actualTitle = actual.getTitle();
        if (!actualTitle.equals(title)) {
            failWithMessage("Expected title to be <%s> but was <%s>", title, actualTitle);
        }

        return this;
    }

    public WebDriverAssert hasUrl(String url) {
        isNotNull();

        String actualUrl = actual.getCurrentUrl();
        if (!actualUrl.equals(url)) {
            failWithMessage("Expected URL to be <%s> but was <%s>", url, actualUrl);
        }

        return this;
    }

    public WebDriverAssert hasUrlContaining(String url) {
        isNotNull();

        String actualUrl = actual.getCurrentUrl();
        if (!actualUrl.contains(url)) {
            failWithMessage("Expected URL to contain <%s> but was <%s>", url, actualUrl);
        }

        return this;
    }

    public WebDriverAssert hasWindowCount(int count) {
        isNotNull();

        Set<String> windowHandles = actual.getWindowHandles();
        if (windowHandles.size() != count) {
            failWithMessage("Expected window count to be <%d> but was <%d>", count, windowHandles.size());
        }

        return this;
    }

    public WebDriverAssert hasSwitchedToWindow(String handle) {
        isNotNull();

        String actualHandle = actual.getWindowHandle();
        if (!actualHandle.equals(handle)) {
            failWithMessage("Expected window handle to be <%s> but was <%s>", handle, actualHandle);
        }

        return this;
    }

    public WebDriverAssert hasNumberOfTabs(int count) {
        isNotNull();

        List<String> tabHandles = List.copyOf(actual.getWindowHandles());
        if (tabHandles.size() != count) {
            failWithMessage("Expected tab count to be <%d> but was <%d>", count, tabHandles.size());
        }

        return this;
    }

    public WebDriverAssert hasFocusOnTab(int tabIndex) {
        isNotNull();

        List<String> tabHandles = List.copyOf(actual.getWindowHandles());
        if (tabIndex < 0 || tabIndex >= tabHandles.size()) {
            failWithMessage("Invalid tab index <%d>. Expected value between <%d> and <%d>", tabIndex, 0, tabHandles.size() - 1);
        }

        String actualHandle = actual.getWindowHandle();
        String expectedHandle = tabHandles.get(tabIndex);
        if (!actualHandle.equals(expectedHandle)) {
            failWithMessage("Expected focus to be on tab <%d> with handle <%s> but was on tab with handle <%s>", tabIndex, expectedHandle, actualHandle);
        }

        return this;
    }

    public WebDriverAssert hasTitleContaining(String text) {
        isNotNull();

        String actualTitle = actual.getTitle();
        if (!actualTitle.contains(text)) {
            failWithMessage("Expected title to contain <%s> but was <%s>", text, actualTitle);
        }

        return this;
    }

    public WebDriverAssert hasElementPresent(String cssSelector) {
        isNotNull();

        boolean isPresent = actual.findElements(By.cssSelector(cssSelector)).size() > 0;
        if (!isPresent) {
            failWithMessage("Expected element with selector <%s> to be present but was not", cssSelector);
        }

        return this;
    }
}