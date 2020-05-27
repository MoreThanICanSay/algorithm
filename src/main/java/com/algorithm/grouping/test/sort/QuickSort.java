package com.algorithm.grouping.test.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 双边循环法
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归条件：startIndex 大于或等于 endIndex
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partiion(arr, startIndex, endIndex);
        // 更具基准元素分成两部分进行递归
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 双边循环法
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partiion(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置（也可以选择任意位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 控制left指针比较并左移
            while (left < right && arr[right] <= pivot) {
                left++;
            }
            // 交换left和right指针所指向元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.printf(Arrays.toString(arr));
    }
}
