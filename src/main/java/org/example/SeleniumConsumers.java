package org.example;

import org.openqa.selenium.WebElement;
import java.util.function.Consumer;

public class SeleniumConsumers {

    // Consumer to click on a WebElement
    public static final Consumer<WebElement> CLICK = WebElement::click;

    // Consumer to send keys to a WebElement
    public static final Consumer<WebElement> SEND_KEYS(String keys) {
        return element -> element.sendKeys(keys);
    }

    // Consumer to get text from a WebElement
    public static final Consumer<WebElement> GET_TEXT= element -> {
        System.out.println("Element text: " + element.getText());
    };
}