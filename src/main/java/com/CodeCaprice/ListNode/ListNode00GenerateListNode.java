package com.CodeCaprice.ListNode;

/**
 * @description: 数组构造链表法
 * @author: Huang Zhiwei
 * @time: 2023/8/31 22:29
 */
public class ListNode00GenerateListNode {
    public static ListNode generateListNodeFromArray(int[] array){
        if(array == null || array.length ==0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int i = 0;i< array.length;i++){
            ListNode newNode = new ListNode(array[i]);
            current.next = newNode;
            current = newNode;
        }
        return dummy.next;
    }
    public static void printListNode(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}
