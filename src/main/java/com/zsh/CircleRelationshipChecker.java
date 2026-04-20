package com.zsh;

import java.util.Locale;
import java.util.Scanner;

public class CircleRelationshipChecker {

    /**
     * 浮点比较误差阈值。
     * 在几何判断中，圆心距 d 可能由于 double 计算误差导致“本该相等却不等”。
     */
    private static final double EPS = 1e-9;

    /** 四类关系（加上一个“重合”用于更清晰的输出，可按需只输出四类）。 */
    public enum Relation {
        CONTAINS,   // 包含（含内切与重合）
        TANGENT,    // 相切（外切/内切）
        OVERLAP,    // 重叠（相交两点）
        SEPARATE,   // 相离（外离/内离）
        COINCIDENT  // 重合（同心且半径相等）
    }

    public static final class Circle {
        private final double x;
        private final double y;
        private final double r;

        public Circle(double x, double y, double r) {
            if (r < 0) {
                throw new IllegalArgumentException("Radius must be non-negative.");
            }
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getR() {
            return r;
        }
    }

    /**
     * 判断两个圆的关系。
     *
     * @param c1 圆1
     * @param c2 圆2
     * @return 关系枚举
     */
    public static Relation relation(Circle c1, Circle c2) {
        // d = 圆心距
        double dx = c1.x - c2.x;
        double dy = c1.y - c2.y;
        double d = Math.sqrt(dx * dx + dy * dy);

        double r1 = c1.r;
        double r2 = c2.r;
        double rSum = r1 + r2;
        double rDiff = Math.abs(r1 - r2);

        // 1) 重合：同心且半径相等
        if (equals(d, 0.0) && equals(r1, r2)) {
            return Relation.COINCIDENT;
        }

        // 2) 相切：圆心距等于 r1+r2（外切），或等于 |r1-r2|（内切）
        if (equals(d, rSum) || equals(d, rDiff)) {
            return Relation.TANGENT;
        }

        // 3) 相离：
        //    外离：d > r1+r2
        //    内离：d < |r1-r2|（一个在另一个内部且不相交）
        if (greater(d, rSum) || less(d, rDiff)) {
            // 注意：d < |r1-r2| 也属于“包含”的一种几何位置，但题目要求区分“包含/相离”。
            // 此处按照“无公共点”的定义归为 SEPARATE。
            return Relation.SEPARATE;
        }

        // 4) 接下来只可能是：|r1-r2| < d < r1+r2
        //    => 相交两点（题目称“重叠”）
        if (greater(d, rDiff) && less(d, rSum)) {
            return Relation.OVERLAP;
        }

        // 5) 兜底：剩余情况包括“严格包含且无交点”已在内离处归为 SEPARATE。
        //    但若你希望把“一个圆完全在另一个圆内（不相交）”归为 CONTAINS，可调整第 3 条。
        return Relation.CONTAINS;
    }

    public static String toChinese(Relation relation) {
        return switch (relation) {
            case CONTAINS -> "包含";
            case TANGENT -> "相切";
            case OVERLAP -> "重叠(相交)";
            case SEPARATE -> "相离";
            case COINCIDENT -> "重合";
        };
    }

    private static boolean equals(double a, double b) {
        return Math.abs(a - b) <= EPS;
    }

    private static boolean less(double a, double b) {
        return a < b && !equals(a, b);
    }

    private static boolean greater(double a, double b) {
        return a > b && !equals(a, b);
    }

    /**
     * 客户程序：读取两圆参数并输出关系，同时给出几组内置示例。
     * 输入格式（空格分隔）：x1 y1 r1 x2 y2 r2
     */
    public static void main(String[] args) {
        // 避免中文环境下小数点解析问题
        Locale.setDefault(Locale.US);

        System.out.println("请输入两圆参数：x1 y1 r1 x2 y2 r2 (例如: 0 0 2 3 0 1)");

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextDouble()) {
                double x1 = scanner.nextDouble();
                double y1 = scanner.nextDouble();
                double r1 = scanner.nextDouble();
                double x2 = scanner.nextDouble();
                double y2 = scanner.nextDouble();
                double r2 = scanner.nextDouble();

                Circle c1 = new Circle(x1, y1, r1);
                Circle c2 = new Circle(x2, y2, r2);

                Relation rel = relation(c1, c2);
                System.out.println("关系: " + toChinese(rel) + " (" + rel + ")");
            }
        } catch (Exception e) {
            System.out.println("输入或参数错误: " + e.getMessage());
        }
    }

    private static void demo(Circle c1, Circle c2) {
        Relation rel = relation(c1, c2);
        System.out.printf("c1[(%.2f,%.2f), r=%.2f], c2[(%.2f,%.2f), r=%.2f] => %s\n",
                c1.x, c1.y, c1.r,
                c2.x, c2.y, c2.r,
                toChinese(rel));
    }
}

