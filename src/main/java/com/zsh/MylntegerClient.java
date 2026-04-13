package com.zsh;

public class MylntegerClient {
    public static void main(String[] args) {
        Mylnteger n1 = new Mylnteger(7);
        Mylnteger n2 = new Mylnteger(24);
        Mylnteger n3 = new Mylnteger(7);

        test("getValue()", n1.getValue() == 7);
        test("get()", n1.get() == 7);

        test("对象方法 isEven()", !n1.isEven() && n2.isEven());
        test("对象方法 isOdd()", n1.isOdd() && !n2.isOdd());
        test("对象方法 isPrime()", n1.isPrime() && !n2.isPrime());

        test("静态方法 isEven(int)", Mylnteger.isEven(10));
        test("静态方法 isOdd(int)", Mylnteger.isOdd(11));
        test("静态方法 isPrime(int)", Mylnteger.isPrime(29));

        test("静态方法 isEven(Mylnteger)", Mylnteger.isEven(n2));
        test("静态方法 isOdd(Mylnteger)", Mylnteger.isOdd(n1));
        test("静态方法 isPrime(Mylnteger)", Mylnteger.isPrime(n1));

        test("equals(int)", n1.equals(7) && !n1.equals(8));
        test("equals(Mylnteger)", n1.equals(n3) && !n1.equals(n2));

        test("parseInt(char[])", Mylnteger.parseInt(new char[]{'1', '2', '3', '4'}) == 1234);
        test("parseInt(String)", Mylnteger.parseInt("-567") == -567);

        System.out.println("测试完成。");
    }

    private static void test(String testName, boolean passed) {
        System.out.printf("%-24s : %s%n", testName, passed ? "PASS" : "FAIL");
    }
}

