package com.zsh;

public class Mylnteger {
    private final int value;

    public Mylnteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int get() {
        return value;
    }

    public boolean isEven() {
        return isEven(value);
    }

    public boolean isOdd() {
        return isOdd(value);
    }

    public boolean isPrime() {
        return isPrime(value);
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        if (value % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isEven(Mylnteger mylnteger) {
        return mylnteger != null && isEven(mylnteger.value);
    }

    public static boolean isOdd(Mylnteger mylnteger) {
        return mylnteger != null && isOdd(mylnteger.value);
    }

    public static boolean isPrime(Mylnteger mylnteger) {
        return mylnteger != null && isPrime(mylnteger.value);
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(Mylnteger mylnteger) {
        return mylnteger != null && this.value == mylnteger.value;
    }

    public static int parseInt(char[] chars) {
        return parseInt(new String(chars));
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
