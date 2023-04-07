
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.Commands;
import io.automation.ui.assertion.CustomAssert;
import io.automation.ui.selenide.MyFramework;
import io.automation.ui.selenide.QuadrupleClick;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.automation.ui.assertion.MyAssert.assertThat;
import static io.automation.ui.selenide.MyFramework.$_;


class BingSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        MyFramework.setUp();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
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
    public void selenideTest(){

        Commands.getInstance().add("quadrupleClick", new QuadrupleClick());
        WebDriverRunner.setWebDriver(driver); //Set driver that Selenide should use

        open("https://www.bing.com");
       String text= $_("#sb_form_q").getText();
       $_("#sb_form_q").quadrupleClick();
    }
}
