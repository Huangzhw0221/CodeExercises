package com.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static com.jianzhioffer.Offer37_2.deserialize;

/**
 * @description: 二叉搜索树的第k大节点
 * 解1：
 * 二叉搜索树的中序遍历就是单调递增的，如果使用后、中、前的顺序那就是单调递减的；利用这个性质可以直接吐出第k大的值
 * 解2：
 * 维护一个大根堆，将树的所有节点送入，然后挨个弹出，弹出的第k个既是目标；但是这个方式效率极低；
 * @author: Huang Zhiwei
 * @time: 2023/5/1 22:58
 */
public class Offer54 {
    public static void main(String[] args) {
        String input ="5 3 6 2 4 null null 1";
        TreeNode out = deserialize(input);
        System.out.println(kthLargest2(out,3));
    }
    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.add(root);
        while (!treeNodeDeque.isEmpty()){
            TreeNode temp = treeNodeDeque.pop();
            priorityQueue.add(temp.val);
            if(temp.left != null){
                treeNodeDeque.add(temp.left);
            }
            if(temp.right !=  null){
                treeNodeDeque.add(temp.right);
            }
        }
        while (k>1){
            priorityQueue.poll();
            k --;
        }
        return priorityQueue.poll();
    }
    public static int kthLargest2(TreeNode root, int k) {
        lastrank(root,k);
        int re = ranked.getLast();
        ranked.clear();
        return re;
    }
    static LinkedList<Integer> ranked = new LinkedList<>();
    public static void lastrank(TreeNode root,int k){
        if(root == null) return;
        lastrank(root.right,k);
        if(ranked.size() == k) return;
        ranked.add(root.val);
        lastrank(root.left,k);
    }
}
