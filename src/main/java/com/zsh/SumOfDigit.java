package com.zsh;

import java.awt.*;
import java.util.Scanner;

public class SumOfDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 1000: ");
        int number = input.nextInt();

        int sum = 0;
        int n = number;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        System.out.println("The sum of the digits is " + sum);
    }
}
