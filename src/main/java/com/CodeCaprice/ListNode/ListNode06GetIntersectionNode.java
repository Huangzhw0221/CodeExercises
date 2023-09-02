package com.CodeCaprice.ListNode;

import java.util.HashSet;

/**
 * @description: 链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * 思路1：哈希集合法，遍历一遍链表A，将节点添加到一个哈希集合中去，在遍历链表B，将节点添加到哈希集合中去，
 * 如果有冲突那么就输出这个节点；如果全部添加进去也没反应就返回null，如方法A
 *
 * 思路2：求出两个链表的长度，并求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置，
 * 比较两个对象是否相等即可，如方法B
 * @author: Huang Zhiwei
 * @time: 2023/9/1 19:59
 */
public class ListNode06GetIntersectionNode {
    public static void main(String[] args) {
        ListNode listNodeA = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{1,2,3,4,5});
        ListNode listNodeB = ListNode00GenerateListNode.generateListNodeFromArray(new int[]{9,8,7});
        listNodeB.next = listNodeA.next;
        ListNode00GenerateListNode.printListNode(getIntersectionNodeA(listNodeA,listNodeB));
    }
    public static ListNode getIntersectionNodeA(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    public static ListNode getIntersectionNodeB (ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0,lenB = 0;
        while (curA != null){
            lenA ++;
            curA = curA.next;
        }
        while (curB != null){
            lenB ++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenB > lenA){
            int tmpLen = lenA;
            lenA =lenB;
            lenB=tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        //长度差
        int gap = lenA -lenB;
        while (gap-- >0){
            curA = curA.next;
        }
        // 遍历curA和curB，遇到相同的则直接返回
        while (curA != null){
            if (curA ==curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}
