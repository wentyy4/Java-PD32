package org.example;

import org.example.exceptions.InvalidNumException;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a = 0, b = 0;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("Enter two numbers: ");
            System.out.println("Enter a number: ");
            a = parseToDouble(reader.nextLine());
            System.out.println("Enter b number: ");
            b = parseToDouble(reader.nextLine());
            System.out.println("Enter an operator (+, -, *, /): ");
            String operator = reader.nextLine();
            switch (operator) {
                case "+":
                    System.out.println(Calculator.addition(a, b));
                    break;
                case "-":
                    System.out.println(Calculator.subtract(a, b));
                    break;
                case "*":
                    System.out.println(Calculator.multiply(a, b));
                    break;
                case "/":
                    try {
                        System.out.println(Calculator.divide(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println("Cannot divide by zero");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator");
            }
            System.out.println("Do you want to continue? (y/n)");
        } while (reader.nextLine().equals("y"));
    }


    private static double parseToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Done");
        }
        return -1;
    }

}