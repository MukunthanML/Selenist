package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertTrue;

public class Selenist {
    static Supplier<By> locatorSupplier(String locatorKey) {
        return locatorSupplier(locatorKey, "xpath");
    }

    static Supplier<By> locatorSupplier(String locatorKey, String locatorType) {
        return () -> {
            try {
                Properties properties = new Properties();
                FileInputStream fis = new FileInputStream("locators.properties");
                properties.load(fis);
                fis.close();
                String propertyKey = locatorKey + "." + locatorType.toLowerCase();
                String locatorValue = properties.getProperty(propertyKey);
                switch (locatorType.toLowerCase()) {
                    case "xpath" -> {
                        return By.xpath(locatorValue);
                    }
                    case "css" -> {
                        return By.cssSelector(locatorValue);
                    }
                    case "id" -> {
                        return By.id(locatorValue);
                    }
                    case "linktext" -> {
                        return By.linkText(locatorValue);
                    }
                    case "partiallinktext" -> {
                        return By.partialLinkText(locatorValue);
                    }
                    case "tagname" -> {
                        return By.tagName(locatorValue);
                    }
                    // Add cases for other valid locator types as needed
                    default -> {
                        throw new IllegalArgumentException("Invalid locator type: " + locatorType);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null; // Or handle the exception as appropriate
            }
        };
    }

    public static void performActionOnElement(WebDriver driver, Supplier<By> locatorSupplier, Consumer<WebElement> action) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locatorSupplier.get()));
            if (element != null && element.isDisplayed() && element.isEnabled()) {
                action.accept(element);

            } else {
                System.out.println("Element not available, clickable, or visible: " + locatorSupplier.get().toString());
            }
        }


public static void assertTrueOnElement(WebDriver driver, Supplier<By> locatorSupplier, Predicate<WebElement> predicate) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locatorSupplier.get()));
    assertTrue(predicate.test(element));}
    }








