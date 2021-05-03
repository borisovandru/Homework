package ru.geekbrains.algorithmjava.lesson4;

import java.util.ArrayList;

public class MDeque {
    private final ArrayList<MyClass> deque = new ArrayList<>();
    private int top = -1;

    public MDeque() {
    }

    public void addLast(MyClass el) {
        this.deque.add(el);
        this.top++;
    }

    public void addFirst(MyClass el) {
        this.deque.add(0, el);
        this.top++;
    }

    public void removeFirst() {
        this.peekFirst();
        this.deque.remove(0);
        this.top--;
    }

    public void removeLast() {
        this.peekLast();
        this.deque.remove(this.top);
        this.top--;
    }

    public void peekFirst() {
        if (this.top != -1) {
            this.deque.get(0).printer();
        } else {
            System.out.println("The stack is empty");
        }
    }

    public void peekLast() {
        if (this.top != -1) {
            this.deque.get(this.top).printer();
        } else {
            System.out.println("The stack is empty");
        }
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }
}
