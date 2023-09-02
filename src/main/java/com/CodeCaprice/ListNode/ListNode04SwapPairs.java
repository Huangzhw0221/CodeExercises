package com.CodeCaprice.ListNode;

/**
 * @description: 两两交换链表中的节点
 * 思路1：虚拟头节点法，创建一个虚拟头节点dummy，令cur = dummy;
 *
 * 循环终止条件：cur.next ==null || [cur.next.next](http://cur.next.next) == null
 *
 * 循环体内部操作：以1，2，3，4，5，6为例
 *
 * temp(1) =cur.next
 * temp1 (3) = cur.next.next.next
 * cur.next = cur.next.next
 * cur.next.next = temp
 * temp.next = temp1
 * cur = cur.next.next
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/1 19:30
 */
public class ListNode04SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,3,4,5,6});
        ListNode00GenerateListNode.printListNode(swapPairs(listNode));
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode temp,temp1;
        while (cur.next != null && cur.next.next != null){
            temp = cur.next;
            temp1 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
