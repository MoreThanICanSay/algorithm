package com.algorithm.grouping.test.binartTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 链表实现二叉树遍历（非递归）
 */
public class BinaryTree1 {
    static class TreeNode {

        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树非递归前序排列
     *
     * @param root 二叉树的根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            // 如果节点没有左孩子，弹出栈顶节点，访问节点的右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树非递归中序遍历
     *
     * @param root
     */
    public static void inOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
//            System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果节点没有左孩子，弹出栈顶节点，访问节点的右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树非递归后续遍历
     *
     * @param root
     */
    public static void postOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode treeNode = root;
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.leftChild != null) {
                s1.push(cur.leftChild);
            }
            if (cur.rightChild != null) {
                s1.push(cur.rightChild);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode cur = s2.pop();
            System.out.println(cur.data);
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

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}
        ));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历：");
        preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历：");
        inOrderTravelWithStack(treeNode);
        System.out.println("后序遍历：");
        postOrderTravelWithStack(treeNode);
    }
}
