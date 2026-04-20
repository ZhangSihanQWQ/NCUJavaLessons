package com.zsh;

import java.util.Scanner;

public class NumberSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入一个浮点数：");
            String input = scanner.nextLine();

            try {
                // 将输入转换为 double 类型
                double num = Double.parseDouble(input);

                // 1. 获取整数部分：直接进行强制类型转换 (int) 会向 0 取整
                int integerPart = (int) num;

                // 2. 获取小数部分：原数减去整数部分
                // 为了避免浮点数精度丢失问题，可以使用 String.format 保留两位小数
                double decimalPart = num - integerPart;

                System.out.println(num + "的整数部分为：" + integerPart);
                // 使用 %.2f 格式化输出，确保结果像 0.14 而不是 0.14000000000000012
                System.out.printf("%s的小数部分为：%.2f\n", input, decimalPart);

                break; // 运行成功后退出循环

            } catch (NumberFormatException e) {
                // 如果用户输入的不是合法的数字，会抛出此异常
                System.out.println("       输入浮点数格式有误");
            }
        }
        scanner.close();
    }
}