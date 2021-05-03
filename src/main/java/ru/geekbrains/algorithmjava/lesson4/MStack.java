package ru.geekbrains.algorithmjava.lesson4;

import java.util.ArrayList;
import java.util.Collection;

public class MStack {
    private final ArrayList<MyClass> stack = new ArrayList<>();
    private int top = -1;

    public MStack() {
    }

    public void push(MyClass el) {
        this.stack.add(el);
        this.top++;
    }

    public void pushSeveral(Collection<MyClass> el) {
        for (MyClass e : el) {
            this.push(e);
        }
    }

    public void pop() {
        this.peek();
        this.stack.remove(this.top);
        this.top--;
    }

    public void peek() {
        if (this.top != -1) {
            this.stack.get(this.top).printer();
        } else {
            System.out.println("The stack is empty");
        }
    }

    public boolean empty() {
        return (this.top == -1);
    }
}