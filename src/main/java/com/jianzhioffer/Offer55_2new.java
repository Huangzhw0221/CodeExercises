package com.jianzhioffer;

/**
 * @description: 平衡二叉树
 * 本题解法抄自leetcode官方题解，自己的做法由于平衡二叉树的理解出错了，所以出现了根本性错误
 * 自顶向下的递归，类似于二叉树的前序遍历
 * @author: Huang Zhiwei
 * @time: 2023/5/2 0:04
 */
public class Offer55_2new {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
