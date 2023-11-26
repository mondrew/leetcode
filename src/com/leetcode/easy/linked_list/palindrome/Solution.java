package com.leetcode.easy.linked_list.palindrome;

import com.leetcode.easy.linked_list.ListNode;

public class Solution {

    /**
     * 1) Reverse first part of the list    <br>
     * 2) Compare two heads                 <br>
     * Time: O(n).                          <br>
     * Memory: O(1).
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode newHead = null;
        // 1. Reverse first part of the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        // 2. Move head if number of elements in the list is ODD
        if (fast != null) {
            head = head.next;
        }
        // 3. Compare two pointers
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.add(node1);
        head.add(node2);
        head.add(node3);
        System.out.println(isPalindrome(head));
    }
}
