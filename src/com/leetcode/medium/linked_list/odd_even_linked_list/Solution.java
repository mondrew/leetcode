package com.leetcode.medium.linked_list.odd_even_linked_list;

import com.leetcode.medium.linked_list.ListNode;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}