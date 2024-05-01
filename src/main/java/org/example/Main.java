package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.example.*;
public class Main {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)
        driver.get("https://www.saucedemo.com/");
        // Define multiple XPath expressions in a text block
        String xpathOfUserName = "//*[@id='user-name']";
        String xpathOfLogo= "//div[@class='login_logo']";


        // Call the utility method and pass the desired action to be performed on each element
        Selenist.assertTrueOnElement(driver,xpathOfLogo, SeleniumPredicates.isElementVisible());
        Selenist.assertTrueOnElement(driver,xpathOfLogo, SeleniumPredicates.elementHasText("Login"));

//        Selenist.performActionOnElement(driver, xpathOfUserName, WebElement::click);
//        Selenist.performActionOnElement(driver, xpathOfUserName, webElement -> webElement.sendKeys("Mtest"));
//        Selenist.performActionOnElement(driver, xpathOfUserName, WebElement::clear);

        //improved version
        Selenist.performActionOnElement(driver, xpathOfUserName, SeleniumConsumers.SEND_KEYS("NewMtest"));
        Selenist.performActionOnElement(driver, xpathOfUserName, SeleniumConsumers.CLICK);
    }
}