package com.example.adsassignment2;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T item;
        MyNode prev, next;

        MyNode(T item) {
            this.item = item;
        }
    }

    private MyNode head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        getNode(index).item = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode next = getNode(index);
            MyNode prev = next.prev;
            MyNode newNode = new MyNode(item);
            newNode.prev = prev;
            newNode.next = next;
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).item;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IllegalStateException();
        return head.item;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IllegalStateException();
        return tail.item;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode node = getNode(index);
        if (node == head) removeFirst();
        else if (node == tail) removeLast();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IllegalStateException();
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IllegalStateException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not supported for LinkedList");
    }

    @Override
    public int indexOf(Object object) {
        int i = 0;
        for (MyNode curr = head; curr != null; curr = curr.next, i++) {
            if (curr.item.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (MyNode curr = tail; curr != null; curr = curr.prev, i--) {
            if (curr.item.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (MyNode curr = head; curr != null; curr = curr.next) {
            arr[i++] = curr.item;
        }
        return arr;
    }

    @Override
    public void clear() {
        MyNode curr = head;
        while (curr != null) {
            MyNode next = curr.next;
            curr.prev = curr.next = null;
            curr.item = null;
            curr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
