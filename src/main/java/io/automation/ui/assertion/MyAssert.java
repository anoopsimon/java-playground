package io.automation.ui.assertion;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class MyAssert<T> extends AbstractAssert<MyAssert<T>, WebElement> {

    public MyAssert(WebElement webElement) {
        super(webElement, MyAssert.class);
    }

    public static MyAssert assertThat(WebElement webElement) {
        return new MyAssert(webElement);
    }

    public MyAssert hasAttribute(String attributeName, String expectedValue) {
        String actualValue = actual.getAttribute(attributeName);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected attribute <%s> to be <%s> but was <%s>", attributeName, expectedValue, actualValue);
        }
        return this;
    }

    public MyAssert hasAttributeValue(String attributeName, String expectedValue) {
        return hasAttribute(attributeName, expectedValue);
    }

    public MyAssert hasCssValue(String propertyName, String expectedValue) {
        String actualValue = actual.getCssValue(propertyName);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected css property <%s> to be <%s> but was <%s>", propertyName, expectedValue, actualValue);
        }
        return this;
    }

    public MyAssert isEnabled() {
        if (!actual.isEnabled()) {
            failWithMessage("Expected element to be enabled");
        }
        return this;
    }

    public MyAssert isDisabled() {
        if (actual.isEnabled()) {
            failWithMessage("Expected element to be disabled");
        }
        return this;
    }

    public MyAssert isDisplayed() {
        if (!actual.isDisplayed()) {
            failWithMessage("Expected element to be displayed");
        }
        return this;
    }

    public MyAssert isNotDisplayed() {
        if (actual.isDisplayed()) {
            failWithMessage("Expected element to not be displayed");
        }
        return this;
    }

    public MyAssert isSelected() {
        if (!actual.isSelected()) {
            failWithMessage("Expected element to be selected");
        }
        return this;
    }

    public MyAssert isNotSelected() {
        if (actual.isSelected()) {
            failWithMessage("Expected element to not be selected");
        }
        return this;
    }

    public MyAssert hasText(String expectedText) {
        String actualText = actual.getText();
        if (!actualText.equals(expectedText)) {
            failWithMessage("Expected text to be <%s> but was <%s>", expectedText, actualText);
        }
        return this;
    }

    public MyAssert hasTextIgnoringCase(String expectedText) {
        String actualText = actual.getText();
        if (!actualText.equalsIgnoreCase(expectedText)) {
            failWithMessage("Expected text to be <%s> (ignoring case) but was <%s>", expectedText, actualText);
        }
        return this;
    }

    public MyAssert containsText(String expectedText) {
        String actualText = actual.getText();
        if (!actualText.contains(expectedText)) {
            failWithMessage("Expected text to contain <%s> but was <%s>", expectedText, actualText);
        }
        return this;
    }

    public MyAssert startsWith(String expectedPrefix) {
        String actualText = actual.getText();
        if (!actualText.startsWith(expectedPrefix)) {
            failWithMessage("Expected text to start with <%s> but was <%s>", expectedPrefix, actualText);
        }
        return this;
    }
}