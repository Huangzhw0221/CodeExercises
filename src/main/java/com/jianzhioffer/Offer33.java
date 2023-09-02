package com.jianzhioffer;

/**
 * @description: 二叉搜索树的后序遍历序列
 * 分两步，第一步是划分左右子树，第二步是递归检查是否是二叉搜索树
 * 划分左右子树，根据二叉搜索树的定义，左子树小于根节点，右子树大于根节点
 * 递归调用时，有两个检验，第一个检验是出现一次大于根节点的值后就应该始终大于根节点了；第二个检验就是递归检验
 * @author: Huang Zhiwei
 * @time: 2023/4/30 20:57
 */
public class Offer33 {
    public static void main(String[] args) {
        int[] input = {1,3,2,6,5};
        System.out.println(verifyPostorder(input));
    }
    public static boolean verifyPostorder(int[] postorder) {
        //划分左右子树，根据二叉搜索树的定义，左子树小于根节点，右子树大于根节点
        return verifyhelper(postorder,0,postorder.length-1);
    }
    public static boolean verifyhelper(int[] postorder,int start,int end){
        if(start >= end){
            return true;
        }
        boolean flagFirst = true;
        int mid = start;
        int midout = start;
        //后续遍历时末尾的就是根节点
        int rootval = postorder[end];
        while(mid < end){
            if(postorder[mid] > rootval){
                //第一次大于根节点的位置就是右子树起点位置，用midout保存
                if(flagFirst){
                    midout = mid;
                }
                //出现一次大于根节点的值后就应该始终大于根节点了，将标志位置为false
                flagFirst = false;
                mid++;
                //小于根节点且标志位为真：表示一直都是小于根节点的
            }else if(postorder[mid] < rootval && flagFirst){
                mid++;
            }else {
                return false;
            }
        }
        //递归调用
        return verifyhelper(postorder,start,midout-1)&&verifyhelper(postorder,midout,end-1);
    }
}
