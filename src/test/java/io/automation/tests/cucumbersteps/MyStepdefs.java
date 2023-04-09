package io.automation.tests.cucumbersteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.Commands;
import io.automation.ui.selenide.MyFramework;
import io.automation.ui.selenide.QuadrupleClick;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static io.automation.ui.selenide.MyFramework.$$;

public class MyStepdefs {

    @Given("I do this")
    public void iDoThis() {

        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        MyFramework.setUp();
        Commands.getInstance().add("customMethod", new QuadrupleClick());
        System.out.println("class called");
        WebDriverRunner.setWebDriver(driver); //Set driver that Selenide should use

        open("https://www.bing.com");
        $$("#sb_form_q")
                .sendKeys("my test");

        $$("#sb_form_q")
                .customMethod()
                .should(Condition.enabled);


    }
}
