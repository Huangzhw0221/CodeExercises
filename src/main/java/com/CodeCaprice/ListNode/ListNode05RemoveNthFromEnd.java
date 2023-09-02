package com.CodeCaprice.ListNode;

/**
 * @description: 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 典型的快慢指针法，让快节点先走n步，然后慢节点再开始，最后删除慢节点即可。
 * @author: Huang Zhiwei
 * @time: 2023/9/1 19:46
 */
public class ListNode05RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,3,4,5});
        ListNode00GenerateListNode.printListNode(removeNthFromEnd(listNode,2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
