package io.automation.ui.assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomAssert
{
        // Assertions for WebElement
        public static <T extends WebElement> io.automation.ui.assertion.MyAssert<T> assertThat(T actual) {
            return new io.automation.ui.assertion.MyAssert(actual);
        }

         //Assertions for WebDriver
        public static <T extends WebDriver> WebDriverAssert<T> assertThat(T actual) {
            return new WebDriverAssert<>(actual);
        }

//        // Generic assertions for any object
//        public static <T> GenericAssert<T> assertThat(T actual) {
//            return new GenericAssert<>(actual);
//        }


}
