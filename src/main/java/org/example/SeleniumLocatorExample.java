package org.example;

import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeleniumLocatorExample {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

        driver.get("https://www.saucedemo.com/");
        // Define multiple XPath expressions in a text block
        String xpaths = """
                       //*[@class="login_logo"]                       
                       //*[@id="login_credentials"]/h4
                       //div[@data-test="login-password"]/h4
                       """;

        // Split the text block into individual XPath expressions
        List<String> xpathExpressions = Arrays.asList(xpaths.split("\\r?\\n"));

        // Find all matching elements for each XPath expression and click on them if they are valid
        xpathExpressions.forEach(xpath -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if (element.isDisplayed()) {
                System.out.println(element.getText());
            }
   });

    driver.close();
    }

}