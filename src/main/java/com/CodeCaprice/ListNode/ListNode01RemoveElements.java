package com.CodeCaprice.ListNode;

/**
 * @description: 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 思路1：用虚拟头节点法，创建一个虚拟的头节点dummy，让dummy的next指向实际链表的头节点。
 * 然后挨个遍历删除即可，如方法A。
 * 思路2：不添加虚拟头节点，使用判断先将头部的等于val的删除，如方法B。
 * @author: Huang Zhiwei
 * @time: 2023/8/31 22:23
 */
public class ListNode01RemoveElements {
    public static void main(String[] args) {
        ListNode listNode = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,6,3,4,5,6});
        listNode = removeElementsB(listNode,6);
        while(listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
    public static ListNode removeElementsA(ListNode head, int val) {
        if(head == null){return head;}

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public static ListNode removeElementsB(ListNode head, int val){
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        //现在的头节点必然不等于val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
