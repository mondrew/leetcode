package com.leetcode.easy.linked_list.reverse;

import com.leetcode.easy.linked_list.ListNode;

public class Solution {

    /**
     * Recursive solution
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        ListNode tmp = newHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * Iterative solution
     * 3 pointers: first, second, third
     */
    public static ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;
        ListNode third = head.next;
        while (second != null) {
            second.next = first;
            first = second;
            second = third;
            if (third != null) {
                third = third.next;
            }
        }
        head = first;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.add(node1);
        head.add(node2);
        head.add(node3);
        head.add(node4);
        head.printLinkedList();
        head = reverseListRecursive(head);
        head.printLinkedList();
        head = reverseListIterative(head);
        head.printLinkedList();
    }
}
