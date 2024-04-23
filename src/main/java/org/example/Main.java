package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
public class Main {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

        driver.get("https://www.saucedemo.com/");
        // Define multiple XPath expressions in a text block
        String xpaths = """
                //*[@id="user-name"]
                //*[@placeholder="Username"]
                """;


        // Call the utility method and pass the desired action to be performed on each element

        //simple
        Selenist.performActionOnElement(driver, xpaths, webElement -> webElement.click());
        Selenist.performActionOnElement(driver, xpaths, webElement -> webElement.sendKeys("Mtest"));
        Selenist.performActionOnElement(driver, xpaths, webElement -> webElement.clear());




        //improved version
        Selenist.performActionOnElement(driver, xpaths, SeleniumConsumers.SEND_KEYS("NewMtest"));
        Selenist.performActionOnElement(driver, xpaths, SeleniumConsumers.CLICK);
    }
}