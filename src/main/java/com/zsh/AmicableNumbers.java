package com.zsh;

import java.util.Scanner;

public class AmicableNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) return;
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        int sum1 = printFactorsAndReturnSum(num1);
        int sum2 = printFactorsAndReturnSum(num2);

        if (sum1 == num2 && sum2 == num1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * 计算并输出因数公式，返回因数之和
     */
    private static int printFactorsAndReturnSum(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n).append(",");

        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                if (sum > 0) {
                    stringBuilder.append("+");
                }
                stringBuilder.append(i);
                sum += i;
            }
        }

        stringBuilder.append("=").append(sum);
        System.out.println(stringBuilder.toString());
        return sum;
    }
}