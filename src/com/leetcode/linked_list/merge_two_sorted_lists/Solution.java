package com.leetcode.linked_list.merge_two_sorted_lists;

import com.leetcode.linked_list.ListNode;

public class Solution {

    /**
     * Best solution
     * Recursion
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * First solution
     * Iterative
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode newList = null;
        ListNode tmp = null;
        ListNode slow1 = new ListNode(0);
        slow1.next = list1;
        ListNode slow2 = new ListNode(0);
        slow2.next = list2;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp = list1;
                list1 = list1.next;
                slow1.next = list1;
            } else {
                tmp = list2;
                list2 = list2.next;
                slow2.next = list2;
            }
            tmp.next = null;
            newList = addNodeBackToList(newList, tmp);
        }
        if (list1 != null) {
            newList = addNodeBackToList(newList, list1);
        } else if (list2 != null) {
            newList = addNodeBackToList(newList, list2);
        }
        return newList;
    }

    public static ListNode addNodeBackToList(ListNode head, ListNode newNode) {
        ListNode tmp = head;
        if (head == null) {
            return newNode;
        } else if (newNode == null) {
            return head;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        list1.add(node1);
        list1.add(node3);
        ListNode list2 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        list2.add(node4);
        list2.add(node5);
        list1.printLinkedList();
        list2.printLinkedList();
        ListNode mergedList = mergeTwoLists(list1, list2);
        mergedList.printLinkedList();
    }
}
