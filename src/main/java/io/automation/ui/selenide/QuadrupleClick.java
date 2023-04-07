package io.automation.ui.selenide;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class QuadrupleClick implements Command<MySelenideElement> {
    @Override
    @Nonnull
    public MySelenideElement execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args) {
        System.out.println("Custom QuadrupleClick");
        return (MySelenideElement) proxy;
    }
}