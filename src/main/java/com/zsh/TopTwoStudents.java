package com.zsh;

import javax.swing.*;
import java.util.Scanner;

public class TopTwoStudents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入学生人数：");
        int n = input.nextInt();

        String topName = "";
        String secondName = "";
        double topScore = -1.0;
        double secondScore = -1.0;

        for (int i = 1; i <= n; i++) {
            System.out.print("请输入学生姓名：");
            String name = input.next();

            System.out.print("请输入学生分数：");
            Double score = input.nextDouble();

            if (score > topScore) {
                secondScore = topScore;
                secondName = topName;

                topScore = score;
                topName = name;
            } else if (score > secondScore) {
                secondScore = score;
                secondName = name;
            }
        }

        System.out.println("最高分学生：" + topName + "  分数：" + topScore);
        System.out.println("第二高分学生：" + secondName + "  分数：" + secondScore);
    }
}