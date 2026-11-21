package AccessbilityScan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauravWebScan {

    public static void main(String [] args){
        WebDriver driver = new ChromeDriver();
        driver.get("file://" + System.getProperty("user.dir")
                + "/src/main/java/HTML/SauravWebsite.html");

        driver.manage().window().maximize();

    }
}
