package ru.geekbrains.algorithmjava.lesson4;

import java.util.ArrayList;
import java.util.Collection;

public class MQueue {
    private final ArrayList<MyClass> queue = new ArrayList<>();
    private int top = -1;

    public MQueue() {
    }

    public void add(MyClass el) {
        this.queue.add(0, el);
        this.top++;
    }

    public void addSeveral(Collection<MyClass> el) {
        for (MyClass e : el) {
            this.add(e);
        }
    }

    public void poll() {
        this.peek();
        this.queue.remove(this.top);
        this.top--;
    }

    public void peek() {
        if (this.top != -1) {
            this.queue.get(this.top).printer();
        } else {
            System.out.println("The queue is empty");
        }
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }
}
