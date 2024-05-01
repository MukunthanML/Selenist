package org.example;
import java.util.function.Consumer;
public class ConsumerDemo
{
    public static void main(String[] args) {
        // Define a consumer function to print a message
        Consumer<String> messageConsumer =
                message -> System.out.println("Message received: " + message);
        // Use the consumer function
        messageConsumer.accept("Hello, world!");
    }
}


