package com.Recruitment;

import com.jianzhioffer.TreeNode;

import java.util.HashSet;

/**
 * @description: 满帮01
 * 二叉树找一家人 40% 非常奇怪
 * @author: Huang Zhiwei
 * @time: 2023/9/24 14:44
 */
public class manbang {
    public static void main(String[] args) {
    }
    public static int maxSum(TreeNode root){
        if(root ==  null){
            return 0;
        }
        return (root.left != null && root.right != null) ? 1 + maxSum(root.left) +maxSum(root.right) : 0;
    }
}
