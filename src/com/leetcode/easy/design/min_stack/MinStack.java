package com.leetcode.easy.design.min_stack;

// Create a custom singly-linked list
public class MinStack {

    static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private int min;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null);
            min = val;
        } else {
            head = new Node(val, head);
        }
        min = Math.min(min, val);
    }

    private void findNewMin() {
        min = Integer.MAX_VALUE;
        Node tmp = head;
        while (tmp != null) {
            min = Math.min(min, tmp.val);
        }
    }

    public void pop() {
        Node oldHead = head;
        if (head != null) {
            head = head.next;
        }
        if (oldHead.val == min) {
            findNewMin();
        }
    }

    public int top() {
        return head != null ? head.val : 0;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

    }
}