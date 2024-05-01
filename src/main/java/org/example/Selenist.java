package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static org.junit.Assert.assertTrue;

public class Selenist {

    public static void performActionOnElement(WebDriver driver, String xpath, Consumer<WebElement> action) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            if (element != null && element.isDisplayed() && element.isEnabled()) {
                action.accept(element);

            } else {
                System.out.println("Element not available, clickable, or visible: " + xpath);
            }
        }




public static void assertTrueOnElement(WebDriver driver, String xpath, Predicate<WebElement> predicate) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    assertTrue(predicate.test(element));}
    }








