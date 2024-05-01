package org.example;
import org.openqa.selenium.WebElement;

import java.util.Objects;
import java.util.function.Predicate;
public class SeleniumPredicates {

    // Predicate to check if element is present
    public static Predicate<? super String> isElementPresent() {
        return Objects::nonNull;
    }

    // Predicate to check if element is visible
    public static Predicate<WebElement> isElementVisible() {
        return WebElement::isDisplayed;
    }

    // Predicate to check if element is clickable
    public static Predicate<WebElement> isElementClickable() {
        return element -> element.isDisplayed() && element.isEnabled();
    }

    // Predicate to check if element has specific text
    public static Predicate<WebElement> elementHasText(String expectedText) {
        return element -> {
            System.out.println("Given Text: "+ expectedText);
            System.out.println("Actual Text: "+ element.getText());
            return element.getText().equals(expectedText);

        };
    }

    // Predicate to check if element has a specific attribute with a given value
    public static Predicate<WebElement> elementHasAttribute(String attributeName, String attributeValue) {
        return element -> element.getAttribute(attributeName).equals(attributeValue);
    }

    // Add more predicates as needed...
}
