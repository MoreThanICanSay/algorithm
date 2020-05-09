package com.algorithm.grouping.test.binartTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 链表实现二叉树遍历（递归）
 */
public class BinaryTree {
    static class TreeNode {

        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树 链表节点的顺序是二叉树前序遍历的顺序
     *
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 二叉树节点
     */
    public static void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.leftChild);
        System.out.println(node.data);
        inOrderTravel(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     *
     * @param node 二叉树节点
     */
    public static void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}
        ));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历：");
        inOrderTravel(treeNode);
        System.out.println("后续遍历");
        postOrderTravel(treeNode);
    }
}
