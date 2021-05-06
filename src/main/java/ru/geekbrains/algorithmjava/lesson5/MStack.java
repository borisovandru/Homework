package ru.geekbrains.algorithmjava.lesson5;

import java.util.ArrayList;

public class MStack {
    private final ArrayList<Pancake> stack = new ArrayList<>();
    private int top = -1;

    public MStack() {
    }

    public void add(Pancake el) {
        this.stack.add(el);
        this.top++;
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
