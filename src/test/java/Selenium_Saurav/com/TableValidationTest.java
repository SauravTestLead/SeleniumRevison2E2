package Selenium_Saurav.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

public class TableValidationTest {

    private static WebDriver driver;

    @Test(priority = -1)
    public void TableCheck() {

        driver = new ChromeDriver();

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(50));

        driver.manage().window().maximize();

        driver.get(Paths.get("src/main/java/HTML/SauravWebsite.html")
                .toAbsolutePath().toUri().toString());

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until the next-page link is visible
        WebElement nextPageButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Open the next page")
                )
        );

        // Scroll down to Next Page button
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'instant', block:'center'});",
                nextPageButton
        );

        // Wait until button is clickable
        wait.until(
                ExpectedConditions.elementToBeClickable(nextPageButton)
        );

        // Open the sample table page.
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
        wait.until(ExpectedConditions.urlContains("SauravNextPage.html"));

    }

    @AfterMethod
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
