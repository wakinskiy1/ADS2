package com.example.adsassignment2;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Testing MyStack ---");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Top: " + stack.peek()); // 20
        System.out.println("Popped: " + stack.pop()); // 20

        System.out.println("--- Testing MyQueue ---");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Front: " + queue.peek()); // A
        System.out.println("Dequeued: " + queue.dequeue()); // A

        System.out.println("--- Testing MyMinHeap ---");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(30);
        heap.add(10);
        heap.add(20);
        System.out.println("Min: " + heap.getMin()); // 10
        System.out.println("Removed Min: " + heap.removeMin()); // 10
        System.out.println("New Min: " + heap.getMin()); // 20
    }
}
