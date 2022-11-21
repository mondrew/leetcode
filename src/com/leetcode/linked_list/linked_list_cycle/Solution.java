package com.leetcode.linked_list.linked_list_cycle;

import com.leetcode.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Walker walks step by step.               <br>
     * Runner walks two steps a time.           <br>
     * If there is a cycle - they will meet.    <br>
     * Memory: O(1).
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    /**
     * Timeout solution
     */
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head) && set.size() != 1) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4, node1);
        head.add(node1);
        head.add(node2);
        head.add(node3);
        System.out.println(hasCycle(head));
    }
}
