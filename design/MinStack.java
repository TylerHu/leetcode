package design;

/**
 * LeetCode155. Min Stack(https://leetcode.com/problems/min-stack/description/)
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Solution: We could define a linked list node, this node is a little bit different from normal linked list node, it not
 * only store it's current value, and it's next node, but also store the minimum value of the list when pushing this node
 * into the list. So we when we need to retrieve the minimum element, we could just get the min value stored in the top
 * element of the list
 */
public class MinStack {
    Node head = null;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            //no other element in the list, so the minimum element is itself
            head = new Node(x, x);
        } else {
            //compare current element and the minimum element stored in the top of the list
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head != null) {
            //set head to it's next element
            head = head.next;
        }
    }

    public int top() {
        return head == null ? 0 : head.val;
    }

    public int getMin() {
        return head == null ? 0 : head.min;
    }

    class Node {
        int val;
        //the minimum element in the list
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }

        Node(int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }


    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */