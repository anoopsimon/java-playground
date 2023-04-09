package io.automation.ui.selenide;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class QuadrupleClick implements Command<BrowserWrapper> {
    @Override
    @Nonnull
    public BrowserWrapper execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args)
    {
        System.out.println("Custom QuadrupleClick : " +  locator.getSearchCriteria());

        WebDriver driver = locator.driver().getWebDriver();
        String id= driver.findElement(By.cssSelector(locator.getSearchCriteria())).getAttribute("id");
        System.out.println(id);
        return (BrowserWrapper) proxy;
    }
}