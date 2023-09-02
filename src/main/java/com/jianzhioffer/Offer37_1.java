package com.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 序列化二叉树
 * 即树的层序遍历和根据层序遍历构造树，其实是很简单的问题
 * @author: Huang Zhiwei
 * @time: 2023/5/1 17:35
 */
public class Offer37_1 {
    public static void main(String[] args) {
        String input ="1 2 3 null null 4 5";
        TreeNode out = deserialize(input);
        System.out.println("finished");
        System.out.println(serialize(out));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //用一个链表存储节点
        Deque<TreeNode> treeNodes = new LinkedList<>();
        //用一个链表存储计数，用来排除跳过的null值，左孩子是2n，右孩子是2n+1；
        Deque<Integer> countqueue = new LinkedList<>();
        treeNodes.add(root);
        countqueue.add(1);
        int former = 0;
        while (!treeNodes.isEmpty()){
            TreeNode temp = treeNodes.pop();
            int count = countqueue.pop();
            if(temp.left !=null){
                treeNodes.add(temp.left);
                countqueue.add(count*2);
            }
            if(temp.right != null){
                treeNodes.add(temp.right);
                countqueue.add(count*2+1);
            }
            while (former != count-1){
                sb.append("null,");
                former++;
            }
            sb.append(temp.val);
            sb.append(",");
            former = count;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] dataqueue = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataqueue[0]));
        //同样构造两个辅助栈
        Deque<TreeNode> treeNodes = new LinkedList<>();
        Deque<Integer> integerDeque = new LinkedList<>();
        treeNodes.add(root);
        integerDeque.add(1);

        int fathercount = 0;
        TreeNode fatherNode = null;
        TreeNode tempNode = null;
        for(int i = 1;i<dataqueue.length;i++){
            if(dataqueue[i].equals("null")){
                continue;
            }
            tempNode = new TreeNode(Integer.parseInt(dataqueue[i]));
            while (true){
                fathercount = integerDeque.peek();
                fatherNode = treeNodes.peek();
                if((i+1) /2 == fathercount){
                    break;
                }else {
                    integerDeque.pop();
                    treeNodes.pop();
                }
            }

            if((i+1) % 2 == 0){
                fatherNode.left = tempNode;
            }else {
                fatherNode.right = tempNode;
                integerDeque.pop();
                treeNodes.pop();
            }
            integerDeque.addLast(i+1);
            treeNodes.addLast(tempNode);
        }
        return root;
    }
}
