package com.leetcode.companies.capital_one.add_two_numbers;

/**
 * LeetCode 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode last = null;
        int remainder = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + remainder;
            if (sum > 9) {
                sum %= 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            if (resultHead == null) {
                resultHead = new ListNode(sum);
                last = resultHead;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + remainder;
            if (sum > 9) {
                sum %= 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            if (resultHead == null) {
                resultHead = new ListNode(sum);
                last = resultHead;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + remainder;
            if (sum > 9) {
                sum %= 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            if (resultHead == null) {
                resultHead = new ListNode(sum);
                last = resultHead;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
            l2 = l2.next;
        }
        if (remainder != 0) {
            last.next = new ListNode(remainder);
        }
        return resultHead;
    }

    public static void main(String[] args) {

    }
}