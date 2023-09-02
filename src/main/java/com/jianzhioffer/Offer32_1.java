package com.jianzhioffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 从上到下打印二叉树
 * 不能使用递归，用栈模拟即可
 * @author: Huang Zhiwei
 * @time: 2023/4/30 20:12
 */
public class Offer32_1 {
    public static void main(String[] args) {

    }
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[]{};
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int[] ans = new int[1000];
        int temp = 0;
        while (!treeNodes.isEmpty()){
            TreeNode out = treeNodes.pop();
            if(out.left != null) treeNodes.add(out.left);
            if(out.right != null) treeNodes.add(out.right);
            ans[temp++] = out.val;
        }
        return Arrays.copyOfRange(ans,0,temp-1);
    }
}
