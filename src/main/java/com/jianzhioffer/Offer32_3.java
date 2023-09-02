package com.jianzhioffer;

import java.util.*;

/**
 * @description: 从上到下打印二叉树 III
 * 之字形打印，和前一题非常类似，但是需要区分奇偶层，相当于再添加一个标志位，如果是奇数就直接添加；如果是偶数层就反序以下再添加；
 * 这是最简单的修改方式
 * @author: Huang Zhiwei
 * @time: 2023/4/30 20:40
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //特殊情况，为空时直接返回
        if(root==null)return new ArrayList<>();
        //tempLayercount表示当前层还剩余几个节点需要打印；nextLayercount表示下一层共有几个节点需要打印
        int tempLayercount = 1;
        int nextLayercount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> innerans = new ArrayList<>();
        //层数计数器
        int countlevel = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            innerans.add(node.val);
            //左右节点不为空就将当前节点的左右节点加入队列，且下一层的计数加一
            if(node.left!=null) {queue.add(node.left);nextLayercount+=1;}
            if(node.right!=null) {queue.add(node.right);nextLayercount+=1;}
            //当前层的计数器减一，如果减到零了就将当前层加入到总的答案list中去
            tempLayercount -= 1;
            if(tempLayercount == 0){
                tempLayercount = nextLayercount;
                countlevel ++;
                if(!innerans.isEmpty()){
                    //奇数层正序，偶数层反序
                    if(countlevel %2 == 1){
                        ans.add(innerans);
                    }else {
                        Collections.reverse(innerans);
                        ans.add(innerans);
                    }

                }
                innerans = new ArrayList<>();
                nextLayercount = 0;
            }
        }
        if(!innerans.isEmpty()){ans.add(innerans);}
        return ans;
    }

}
