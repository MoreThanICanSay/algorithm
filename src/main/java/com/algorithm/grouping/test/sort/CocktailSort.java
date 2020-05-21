package com.algorithm.grouping.test.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 第一轮从左到右，第二轮从右到左
 */
public class CocktailSort {

    public static void sort(int array[]) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            // 是否是有序队列的标记
            boolean isSort = true;
            // 奇数轮，从左到右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 有元素交换，所以不是有序的
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }

            // 偶数轮之前，先将isSort标记为true
            isSort = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;

                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1,0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
