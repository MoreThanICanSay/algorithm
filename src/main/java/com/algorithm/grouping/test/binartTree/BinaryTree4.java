package com.algorithm.grouping.test.binartTree;

import java.util.Arrays;

/**
 * （优先队列）二叉堆
 */
public class BinaryTree4 {

    private int[] array;
    private int size;

    public BinaryTree4(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    /**
     * 入队
     *
     * @param key 入队元素
     */
    public void enQueue(int key) {
        // 队列长度超出范围，扩容
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjuest();
    }

    /**
     * 出队
     *
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (size <= 0)
            throw new Exception("the queue is empty");
        // 获取堆顶元素
        int head = array[0];
        // 让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjuest();
        return head;
    }

    /**
     * 元素上浮调整
     */
    private void upAdjuest() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 元素下沉
     */
    private void downAdjuest() {
        // temp 用于插入父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 > size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    private void resize() {
        // 队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6,  7, 8, 9, 10, 0};

        BinaryTree4 binaryTree4 = new BinaryTree4(array);
        binaryTree4.enQueue(5);

        try {
            binaryTree4.deQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
