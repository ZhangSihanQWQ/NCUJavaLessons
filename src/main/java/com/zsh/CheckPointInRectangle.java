package com.zsh;

import java.util.Scanner;

public class CheckPointInRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a point with two coordinates: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        // 使用 Math.abs 获取绝对值
        boolean isInRectangle = (Math.abs(x) <= 10.0 / 2) && (Math.abs(y) <= 5.0 / 2);

        if (isInRectangle) {
            System.out.println("Point (" + x + ", " + y + ") is in the rectangle");
        } else {
            System.out.println("Point (" + x + ", " + y + ") is not in the rectangle");
        }

        input.close();
    }
}