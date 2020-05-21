package com.algorithm.grouping.test.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻的元素两两比较，当一个元素大于右侧相邻元素，交换位置
 */
public class BubbleSort {

    /**
     * 传统冒泡排序
     *
     * @param array
     */
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 元素有交换，则说明元素的无序，没有交换，说明元素已经有序
     *
     * @param array
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一次的初始值都是true
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    isSort = false;
                }
            }
            if (isSort)
                break;
        }
    }

    /**
     * 添加无序列表的边界
     *
     * @param array
     */
    public static void sort3(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只要到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // 有元素交换，所以不是有序的，标记为false
                    isSorted = false;
                    // 更新最后一次为交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 3, 2, 5, 7, 8, 9, 1};
//        sort1(array);
//        sort2(array);
        sort3(array);
        System.out.println(Arrays.toString(array));
    }
}
