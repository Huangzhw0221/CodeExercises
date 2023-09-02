package com.jianzhioffer;
import java.util.*;

public class tree {
    public static class Node {
        int val;
        ArrayList<Node> child = new ArrayList<>();
        Node parent;
        boolean isBlocked = false;
        Node(int val){
            this.val = val;
        }
        void setBlock(boolean isBlocked){
            this.isBlocked = isBlocked;
        }
    }
    static List<Node> nodeList=new ArrayList<>();
    public static void creat(int n){//初始化二叉树,将传进来的值创建为二叉树
        //新建一个list集合，将数据变为各个节点
        for (int i=0;i<n;i++) {
            nodeList.add(new Node(i));
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        creat(n);
        int m = sc.nextInt();
        while (m-->0){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            nodeList.get(parent).child.add(nodeList.get(child));
            nodeList.get(child).parent = nodeList.get(parent);
        }
        int b = sc.nextInt();
        while (b-->0){
            int block = sc.nextInt();
            nodeList.get(block).setBlock(true);
        }

        tracking(nodeList.get(0));
        if( res.isEmpty()){
            System.out.println("NULL");
        }else {
            int minLen = Integer.MAX_VALUE;
            for (ArrayList<Integer> arrayList : res) {
                minLen = Math.min(minLen,arrayList.size());
            }
            boolean flag = false;
            int index = 0;
            for(int i = 0; i < minLen; i++){
                int min = res.get(0).get(i);
                for(int j = 0; j < res.size(); j++){
                    if(res.get(j).get(i) < min){
                        index = j;
                        flag = true;
                        break;
                    }
                }
                if(flag) {break;}
            }
            for (int i = minLen - 1; i >= 0; i--) {
                if(i==0){
                    System.out.print(res.get(index).get(i));
                }else{
                    System.out.print(res.get(index).get(i));
                    System.out.print("->");
                }
            }

        }

    }



    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void tracking(Node root){
        if(root.isBlocked) return;
        if(root.child.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            while (root.parent!=null){
                list.add(root.parent.val);
                root = root.parent;
            }
            res.add(list);
            return;
        }

        for (Node node : root.child) {
            tracking(node);
        }
    }
}
