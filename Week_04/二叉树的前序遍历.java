package com.leetode.application;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class 二叉树的前序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归方式
     * 时间复杂度 O(n)
     * 空间复杂度O(n) (result 存放结果数据)
     */
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        //前序遍历
        List<Integer> result = new ArrayList<>();
        preTraversal(result, root);
        return result;
    }

    private void preTraversal(List<Integer> result, TreeNode root) {
        //terminate
        if (root == null) return;
        //process
        result.add(root.val);
        //next leval
        preTraversal(result, root.left);
        preTraversal(result, root.right);
        //revert
    }

    /**
     * 栈的方式, DFS深度优先
     * 时间复杂度O(n)
     * 空间复杂度O(n) (存放结果数据的result)
     */
    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 队列的方式, BFS广度优先
     * 时间复杂度O(n)
     * 空间复杂度O(n) (存放结果数据的result)
     */
    // TODO: 2020/9/15 错误 
    public List<Integer> preorderTraversalQueue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            result.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return result;
    }
}
