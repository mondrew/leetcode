package com.leetcode.linked_list.delete_node;

import com.leetcode.linked_list.ListNode;

public class Solution {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.add(node1);
        head.add(node2);
        head.add(node3);
        deleteNode(node1);
    }
}
