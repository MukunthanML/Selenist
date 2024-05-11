package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import static org.example.Selenist.*;
import static org.example.SelenistConsumers.*;
import static org.example.SelenistPredicates.*;



public class Main {

    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        assertTrueOnElement(driver, locatorSupplier("username"), isElementVisible());
        assertTrueOnElement(driver, locatorSupplier("loginlogo"), hasElementTextAs("Swag Labs"));
        performActionOnElement(driver, locatorSupplier("username"), SEND_KEYS("Mtester"));
//        Selenist.performActionOnElement(driver, xpathOfUserName, WebElement::click);
//        Selenist.performActionOnElement(driver, xpathOfUserName, webElement -> webElement.sendKeys("Mtest"));
//        Selenist.performActionOnElement(driver, xpathOfUserName, WebElement::clear);

        //improved version
//        Selenist.performActionOnElement(driver, xpathOfUserName, SelenistConsumers.SEND_KEYS("NewMtest"));
//        Selenist.performActionOnElement(driver, xpathOfUserName, SelenistConsumers.CLICK);
    }
}