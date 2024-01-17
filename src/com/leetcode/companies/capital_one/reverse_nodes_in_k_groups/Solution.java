package com.leetcode.companies.capital_one.reverse_nodes_in_k_groups;

/**
 * LeetCode 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class Solution {

    private ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode groupPrev = dummyHead;
        ListNode kth = getKthNode(groupPrev, k);
        while (kth != null) {
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode current = groupPrev.next;
            while (current != groupNext) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode nextPrevGroup = groupPrev.next;
            groupPrev.next = prev; // prev == kth
            groupPrev = nextPrevGroup;
            kth = getKthNode(groupPrev, k);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}