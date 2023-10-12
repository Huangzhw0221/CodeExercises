package com.Recruitment;

import com.CodeCaprice.ListNode.ListNode;

/**
 * @description: 满帮02
 * 链表问题
 * @author: Huang Zhiwei
 * @time: 2023/9/24 14:54
 */
public class manbang02 {
    public static ListNode mergeNode(ListNode head){
        if(head == null){
            return head;
        }
        head.val = head.val*head.next.val;
        head.next = mergeNode(head.next.next);
        return head;
    }
}
