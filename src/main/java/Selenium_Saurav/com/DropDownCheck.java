package Selenium_Saurav.com;

import io.cucumber.prettyformatter.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownCheck {
    private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file://" + System.getProperty("user.dir")
                + "/src/main/java/HTML/SauravWebsite.html");

        driver.manage().window().maximize();

        // check current url and Title
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        System.out.println("-----------------------");

        System.out.println("Nav bar option check ");
        // Validate all the NAV BAR
        List<WebElement> Nav = driver.findElements(By.xpath("//div[@id=\"mainNavigation\"]//ul//li/a"));
        System.out.println("Number of Navigation Links: " + Nav.size());
        for(WebElement link : Nav){
            System.out.println("Link Text: " + link.getText());
        }

        Thread.sleep(5000);
        // Select the static DropDown
       driver.findElement(
                By.xpath("(//div[@id='mainNavigation']//a)[1]")).click();

       Thread.sleep(5000);

       System.out.println("Statis DropDown check options");
        // <----- Static DropDown check ----->
        WebElement element = driver.findElement(By.id("language"));
        Select select = new Select(element);
        select.getOptions();
        for(WebElement option : select.getOptions()){
            System.out.println("Option Text:"+option.getText());
        }

        driver.quit();

        }
    }

