package com.leetcode.companies.capital_one.reverse_linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}