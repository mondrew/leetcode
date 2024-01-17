package com.leetcode.companies.capital_one.reverse_linked_list;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(ListNode node) {
        ListNode tmp = this;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void printLinkedList() {
        int i = 0;
        ListNode tmp = this;
        while (tmp != null) {
            System.out.print("[Node " + i + " val = " + tmp.val + "] -> ");
            System.out.print(tmp.next == null ? "null" : " ");
            tmp = tmp.next;
            i++;
        }
        System.out.println();
    }
}
