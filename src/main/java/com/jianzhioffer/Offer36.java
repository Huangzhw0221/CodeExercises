package com.jianzhioffer;

/**
 * @description: 二叉搜索树与双向链表
 * 一种做法是将搜索树的值进行排列后再构造树；但是由于不能创建新的节点，所以这个方法不是很好；
 * 先使用中序遍历，对于搜索树来说序列就是递增序列，相当于排好序了，可以用queue来辅助；
 * 然后用链表的pre、cur操作这个queue
 * leetcode给出了递归的解法，比上述思路好很多
 * @author: Huang Zhiwei
 * @time: 2023/5/1 17:22
 */
public class Offer36 {
    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        //中序遍历，操作中间的所有节点
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
