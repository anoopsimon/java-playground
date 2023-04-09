package io.automation.tests.unittests;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.automation.ui.assertion.CustomAssert;
import io.automation.ui.selenide.MyFramework;
import io.automation.ui.selenide.QuadrupleClick;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.automation.ui.assertion.MyAssert.assertThat;
import static io.automation.ui.selenide.MyFramework.$$;


class BingSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        MyFramework.setUp();
        Commands.getInstance().add("customMethod", new QuadrupleClick());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @ExtendWith(TextReportExtension.class)
    public void testBingSearch() {
        // Navigate to bing.com
        driver.get("https://www.bing.com");

        // Find the search box element and enter a search query
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        assertThat(searchBox)
                .isDisplayed();

        CustomAssert.assertThat(driver).hasNumberOfTabs(1);
        CustomAssert.assertThat(searchBox).isDisplayed();

        searchBox.sendKeys("selenium");
        searchBox.sendKeys(Keys.ENTER);
       // MyAssert.assertThat("search?q=selenium");

        //assertThat(title()).isEqualTo("Selenide - Google Search");


    }

    @Test
    @ExtendWith(TextReportExtension.class)
    public void selenideTest() throws IOException {

        WebDriverRunner.setWebDriver(driver); //Set driver that Selenide should use

       open("https://www.bing.com");
       $$("#sb_form_q")
               .sendKeys("my test");

       $$("#sb_form_q")
               .customMethod()
               .should(Condition.disabled);



    }



}
