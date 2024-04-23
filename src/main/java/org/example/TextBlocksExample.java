package org.example;

public class TextBlocksExample {
    public static void main(String[] args) {
        String html = """
            <html>
                <head>
                    <title>Hello, Text Blocks!</title>
                </head>
                <body>
                    <h1>Welcome to Text Blocks</h1>
                    <p>This is a simple example of text blocks in Java.</p>
                </body>
            </html>
            """;

        System.out.println(html);
        String json = """
            {
                "name": "John Doe",
                "age": 30,
                "email": "john.doe@example.com",
                "address": {
                    "street": "123 Main St",
                    "city": "Anytown",
                    "state": "Anystate",
                    "zip": "12345"
                },
                "phoneNumbers": [
                    "123-456-7890",
                    "098-765-4321"
                ]
            }
            """;








        System.out.println(json);
    }
}
