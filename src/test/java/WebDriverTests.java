
import io.automation.ui.assertion.Asssss;
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
import java.time.temporal.TemporalUnit;
import io.automation.ui.assertion.MyAssert;

import static io.automation.ui.assertion.MyAssert.assertThat;


class BingSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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

        Asssss.assertThat(driver).hasNumberOfTabs(1);
        Asssss.assertThat(searchBox).isDisplayed();

        searchBox.sendKeys("selenium");
        searchBox.sendKeys(Keys.ENTER);



    }
}
