package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Selenist {

    public static void performActionOnElement(WebDriver driver, String xpaths, Consumer<WebElement> action) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

        // Split the text block into individual XPath expressions
        List<String> xpathExpressions = Arrays.asList(xpaths.split("\\r?\\n"));

        // Find all matching elements for each XPath expression and perform the specified action
        for (String xpathExpression : xpathExpressions) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
            if (element != null && element.isDisplayed() && element.isEnabled()) {
                action.accept(element);
                break;

            } else {
                System.out.println("Element not available, clickable, or visible: " + xpathExpression);
            }
        }
        }



    public static String getTextFromElement(WebDriver driver, String xpaths) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the timeout (in seconds)

        // Split the text block into individual XPath expressions
        List<String> xpathExpressions = Arrays.asList(xpaths.split("\\r?\\n"));

        // Initialize a StringBuilder to concatenate text from multiple elements
        StringBuilder textBuilder = new StringBuilder();

        // Find all matching elements for each XPath expression and concatenate their text
        for (String xpathExpression : xpathExpressions) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
            if (element != null && element.isDisplayed()) {
                String elementText = element.getText();
                textBuilder.append(elementText).append("\n");
                // Assert against the expected text
                } else {
                System.out.println("Element not available or visible: " + xpathExpression);
            }
        }

        // Return the concatenated text
        return textBuilder.toString();
}

}