package com.leetcode.medium.linked_list.add_two_numbers;

import com.leetcode.medium.linked_list.ListNode;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOn = 0;
        ListNode head = null;
        ListNode tmp = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carryOn;
            if (sum > 9) {
                sum %= 10;
                carryOn = 1;
            } else {
                carryOn = 0;
            }
            if (head == null) {
                head = new ListNode(sum);
                tmp = head;
            } else {
                tmp.next = new ListNode(sum);
                tmp = tmp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carryOn > 0) {
            tmp.next = new ListNode(carryOn);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9, node4);
        ListNode node6 = new ListNode(9, node5);
        ListNode node7 = new ListNode(9, node6);
        ListNode node8 = new ListNode(9, node7);
        ListNode node9 = new ListNode(9, node8);
        ListNode node10 = new ListNode(9, node9);
        ListNode node11 = new ListNode(9, node10);
        ListNode node12 = new ListNode(9, node11);
        ListNode head2 = new ListNode(1, node12);
        ListNode result = addTwoNumbers(head1, head2);
        System.out.println(result);
    }
}