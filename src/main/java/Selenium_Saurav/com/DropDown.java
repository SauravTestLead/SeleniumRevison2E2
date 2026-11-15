package Selenium_Saurav.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class DropDown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("jetbrains://idea/navigate/reference?project=Selenium&path=HTML%2FSauravWebsite.html");
        driver.manage().window().fullscreen();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.manage().window().maximize();
    }
}
