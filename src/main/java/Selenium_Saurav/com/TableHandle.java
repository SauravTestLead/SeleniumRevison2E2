package Selenium_Saurav.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;



public class TableHandle {
    private static WebDriver driver;
    public static void main(String[] args) {
       driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
            driver.get(Paths.get("src/main/java/HTML/SauravWebsite.html")
                    .toAbsolutePath().toUri().toString());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement nextPageLink = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//a[normalize-space(.)='Open the next page']")
                    )
            );
            String buttonText = nextPageLink.getText();
            System.out.println("Located button text: " + buttonText);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});",
                    nextPageLink
            );

            WebElement clickableNextPageLink = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[normalize-space(.)='Open the next page']")
                    )
            );
            clickableNextPageLink.click();
            wait.until(ExpectedConditions.urlContains("SauravNextPage.html"));

        } finally {
            driver.quit();
        }
    }
}


