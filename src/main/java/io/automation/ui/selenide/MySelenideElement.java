package io.automation.ui.selenide;


import com.codeborne.selenide.SelenideElement;

public interface MySelenideElement extends SelenideElement
{
    MySelenideElement tripleClick();

    MySelenideElement quadrupleClick();
}