package com.zsh;
/**
 * @author:zhangsihanqwq
 * * 1. 分析:
 * - 输入：投资金额 (double), 年利率 (double, 如 4.25 代表 4.25%), 投资年限 (int)。
 * - 输出：计算后的未来累计价值 (double)，格式化为两位小数。
 * - 公式说明：未来价值 = 本金 * (1 + 年利率/1200) ^ (年数 * 12)。
 * * 2. 设计:
 * Step 1: 导入 java.util.Scanner 类并创建实例。
 * Step 2: 提示用户并依次读取投资金额、年利率和年数。
 * Step 3: 使用 Math.pow(1 + rate/1200, years * 12) 计算幂运算部分，乘以本金 amount 得到最终价值。
 * Step 4: 使用 printf 输出保留两位的最终结果。
 */
import java.util.Scanner;

public class InvestmentCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double amount = input.nextDouble();

        System.out.print("Enter annual interest rate: ");
        double rate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        double value = amount * Math.pow(1.0 + rate/1.2e3, 12 * years);
        System.out.printf("Accumulated value is %.2f", value);
    }
}