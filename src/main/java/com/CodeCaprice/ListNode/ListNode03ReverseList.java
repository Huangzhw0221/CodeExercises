package com.CodeCaprice.ListNode;

/**
 * @description: 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *思路1：使用双指针写法，创建一个pre，cur，temp，分别标识前一个，当前，下一个。那么步骤应当为：
 * temp后移一位；
 * cur指向pre；
 * pre移动到cur；
 * cur移动到temp；
 *
 * @author: Huang Zhiwei
 * @time: 2023/9/1 18:58
 */
public class ListNode03ReverseList {
    public static void main(String[] args) {
        ListNode listNode = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,3,4,5,6});
        listNode = reverseList(listNode);
    }
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
