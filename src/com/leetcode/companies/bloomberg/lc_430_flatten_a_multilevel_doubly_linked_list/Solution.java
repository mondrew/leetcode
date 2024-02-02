package com.leetcode.companies.bloomberg.lc_430_flatten_a_multilevel_doubly_linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        Node dummyHead = new Node();
        Node savedDummyHead = dummyHead;
        deque.addFirst(head);
        while (!deque.isEmpty()) {
            Node curr = deque.poll();
            if (curr.next != null) {
                deque.push(curr.next);
            }
            if (curr.child != null) {
                deque.push(curr.child);
            }
            curr.child = null;
            dummyHead.next = curr;
            curr.prev = dummyHead;
            dummyHead = dummyHead.next;
        }
        savedDummyHead.next.prev = null;
        return savedDummyHead.next;
    }
}