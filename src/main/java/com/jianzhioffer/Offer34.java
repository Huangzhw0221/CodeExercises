package com.jianzhioffer;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: 二叉树中和为某一值的路径
 * 由于需要返回List<List<Integer>>类型的量，所以不能将父亲节点的值直接加到左右节点上
 * 使用三个全局变量，sum、innerans、ans辅助
 * 用一个helper函数作为递归函数，分别递归左右子树，需要注意的是innerans的清理时机、深拷贝innerans加到ans中去
 * @author: Huang Zhiwei
 * @time: 2023/5/1 16:25
 */
public class Offer34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(pathSum(root, 3));
    }
    static int sum = 0;
    static LinkedList<Integer> innerans = new LinkedList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        //由于innerans和ans是static的，在测试中多次调用函数，所以需要先将它清理
        ans.clear();
        innerans.clear();
        //为空时直接返回空
        if(root == null) return new ArrayList<>();
        pathSumHelper(root,target);
        return ans;
    }
    public static void pathSumHelper(TreeNode root, int target){
        //当前值一定不为空，就先加上
        sum += root.val;
        innerans.add(root.val);
        if(root.right != null || root.left != null){
            //分别对左右子树做递归
            if(root.right !=null){
                pathSumHelper(root.right,target);
            }
            if(root.left != null){
                pathSumHelper(root.left,target);
            }
            //减去当前节点的信息
            sum -= root.val;
            innerans.removeLast();
        }else {
            //比较当前和与目标，如果相同就加入答案，需要深拷贝一份
            if(sum == target){
                ans.add(new LinkedList<Integer>(innerans));
            }
            sum -= root.val;
            innerans.removeLast();
        }
    }
}
