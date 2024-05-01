package org.example;

import java.util.function.Predicate;

public class PredicateDemo {

        public static void main(String[] args) {
            // creating a predicate to test if a string is empty
            Predicate<String> isEmpty = String::isEmpty;

            // testing the predicate
            System.out.println(isEmpty.test(""));    // true
            System.out.println(isEmpty.test("Hello"));    // false
        }
    }
    // Test with valid username

