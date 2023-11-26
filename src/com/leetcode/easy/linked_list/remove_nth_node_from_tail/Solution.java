package com.leetcode.easy.linked_list.remove_nth_node_from_tail;

import com.leetcode.easy.linked_list.ListNode;

public class Solution {

    /**
     * One pass solution                    <br>
     * Temporary pre-head pointer (PH)      <br>
     * +2 additional window-pointers:       <br>
     * - Pre-delete pointer (PD)            <br>
     * - End-runner pointer (ER)            <br>
     * Say n = 3;                           <br>
     * BEFORE moving window                 <br>
     *  PH -> N1 -> N2 -> N3 -> N4 -> null  <br>
     *  ↑__________________↑                <br>
     *  PD_________________ER               <br>
     *                                      <br>
     *  AFTER moving window                 <br>
     *  PH -> N1 -> N2 -> N3 -> N4 -> null  <br>
     *        ↑__________________↑          <br>
     *        P__________________ER       <br>
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode preDelete = tempHead;
        ListNode endRunner = tempHead;
        while (n-- > 0) {
            endRunner = endRunner.next;
        }
        while (endRunner.next != null) {
            endRunner = endRunner.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return tempHead.next;
    }

    /**
     * First solution
     * In two pass :(
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null && n == 1) {
            return null;
        }
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        if (n == size) {
            return head.next;
        }
        tmp = head;
        for (int i = 0; i < size - 1 - n; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
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
        int n = 2;
        head.printLinkedList();
        head = removeNthFromEnd(head, n);
        head.printLinkedList();
    }
}
