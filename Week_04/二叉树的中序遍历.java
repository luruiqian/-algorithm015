package com.leetode.application;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class 二叉树的中序遍历 {
    /**
     * 递归方式
     * 时间复杂度 O(n)
     * 空间复杂度O(n) (result 用于存放结果)
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(result, root);
        return result;
    }

    private void inorderTraversalHelper(List<Integer> result, TreeNode root) {
        //terminage
        if (root == null) return;
        //process
        //next level
        inorderTraversalHelper(result, root.left);
        result.add(root.val);
        inorderTraversalHelper(result, root.right);
        //revert
    }

    /**
     * 迭代方式
     * 时间复杂度 O(n)
     * 空间复杂度O(n) (n 是树的高度)
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    /**
     * 莫里斯方法
     * 空间复杂度 O(n)
     * 空间复杂度 O(1)
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                TreeNode temp = root;
                node.right = temp;
                root = root.left;
                temp.left = null;
            } else {
                result.add(root.val);
                root = root.right;
            }
        }
        return result;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
