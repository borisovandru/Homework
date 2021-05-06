package ru.geekbrains.algorithmjava.lesson5;

import java.util.ArrayList;

public class MRecursiveStack {
    private final ArrayList<Pancake> stack = new ArrayList<>();
    private int top = -1;

    public MRecursiveStack() {
    }

    public void put(Pancake el) {
        this.stack.add(el);
        this.top++;
    }

    public void popAllRecursively() {
        this.peek();
        this.stack.remove(this.top);
        this.top--;
        if (!this.empty()) {
            this.popAllRecursively();
        }
    }

    public void peek() {
        if (this.top != -1) {
            this.stack.get(this.top).printer();
        } else {
            System.out.println("The recursive stack is empty");
        }
    }

    public boolean empty() {
        return (this.top == -1);
    }
}
