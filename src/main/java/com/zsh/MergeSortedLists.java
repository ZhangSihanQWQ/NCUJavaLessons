package com.zsh;

import java.util.Scanner;

public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter list1 size and contents: ");
        int size1 = input.nextInt();
        int[] list1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            list1[i] = input.nextInt();
        }

        System.out.print("Enter list2 size and contents: ");
        int size2 = input.nextInt();
        int[] list2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            list2[i] = input.nextInt();
        }

        int[] mergedList = merge(list1, list2);

        System.out.print("The merged list is ");
        for (int e : mergedList) {
            System.out.print(e + " ");
        }
    }

    /**
     * 合并两个有序数组
     * 比较次数限制在 list1.length + list2.length 之内
     * 时间复杂度O(n + m)
     */
    public static int[] merge(int[] list1, int[] list2) {
        int[] result = new int[list1.length + list2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < list1.length && j < list2.length) {
            if (list1[i] <= list2[j]) {
                result[k++] = list1[i++];
            } else {
                result[k++] = list2[j++];
            }
        }

        while (i < list1.length) {
            result[k++] = list1[i++];
        }

        while (j < list2.length) {
            result[k++] = list2[j++];
        }

        return result;
    }
}