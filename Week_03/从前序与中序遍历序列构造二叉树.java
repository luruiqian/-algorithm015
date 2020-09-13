package com.leetode.application;

import java.util.HashMap;

class 从前序与中序遍历序列构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(0, preorder.length, 0, inorder.length, preorder, inorder, map);
    }

    private TreeNode buildTreeHelper(int pre_start, int pre_end, int in_start, int in_end, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (pre_start == pre_end) return null;
        int root_val = preorder[pre_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int left_num = i_root_index - in_start;
        root.left = buildTreeHelper(pre_start + 1, pre_start + left_num + 1, in_start, i_root_index, preorder, inorder, map);
        root.right = buildTreeHelper(pre_start + left_num + 1, pre_end, i_root_index + 1, in_end, preorder, inorder, map);
        return root;
    }
}
