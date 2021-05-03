package ru.geekbrains.algorithmjava.lesson4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //Задание 4.1: простой стек и его базовые методы на основе объектного списка моего класса, время

        LinkedList<MyClass> myClassLinkedList = new LinkedList<>();
        myClassLinkedList.add(new MyClass(599.0, true, "Socks"));
        myClassLinkedList.add(new MyClass(2199.90, false, "Hat"));
        myClassLinkedList.add(new MyClass(999.0, true, "Gloves"));
        myClassLinkedList.add(new MyClass(10_000.0, true, "Jacket"));
        myClassLinkedList.add(new MyClass(7499.0, true, "Dress"));
        myClassLinkedList.add(new MyClass(2999.0, true, "Jeans"));

        System.out.println("Basic linked list: ");
        for (MyClass elem : myClassLinkedList) {
            elem.printer();
        }
        System.out.println();

        MStack myClassMStack = new MStack();

        long startTimeMStackAdd = System.nanoTime();
        myClassMStack.pushSeveral(myClassLinkedList);
        double elapsedNanosMStackAdd = (double) (System.nanoTime() - startTimeMStackAdd) / 1000000;
        System.out.println("4.1 Stack based on array list created");
        System.out.println("\tTime elapsed on 'pushSeveral': " + elapsedNanosMStackAdd + " milliseconds\n");

        System.out.println("peek()");
        long startTimeMStackPeek = System.nanoTime();
        myClassMStack.peek();
        double elapsedNanosMStackPeek = (double) (System.nanoTime() - startTimeMStackPeek) / 1000000;
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosMStackPeek + " milliseconds\n");


        while (!myClassMStack.empty()) {
            myClassMStack.pop();
        }
        System.out.println();
        System.out.println("Stack is empty: " + myClassMStack.empty() + "\n");

        //Задание 4.2: простая очередь, базовые методы, вспомогательные методы, время

        MQueue myClassMQueue = new MQueue();

        long startTimeMQueueAdd = System.nanoTime();
        myClassMQueue.addSeveral(myClassLinkedList);
        double elapsedNanosMQueueAdd = (double) (System.nanoTime() - startTimeMQueueAdd) / 1000000;
        System.out.println("4.2 Queue based on linked list created");
        System.out.println("\tTime elapsed on 'addAll': " + elapsedNanosMQueueAdd + " milliseconds\n");

        System.out.println("peek()");
        long startTimeMQueuePeek = System.nanoTime();
        myClassMQueue.peek();
        double elapsedNanosMQueuePeek = (double) (System.nanoTime() - startTimeMQueuePeek) / 1000000;
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosMQueuePeek + " milliseconds\n");

        while (!myClassMQueue.isEmpty()) {
            myClassMQueue.poll();
        }
        System.out.println();

        System.out.println("Queue is empty: " + myClassMQueue.isEmpty() + "\n");

        //Задание 4.3: простой дек, базовые методы, время

        MDeque myClassMDeque = new MDeque();

        long startTimeMDequeAdd = System.nanoTime();
        myClassMDeque.addFirst(myClassLinkedList.get(3));
        myClassMDeque.addFirst(myClassLinkedList.get(2));
        myClassMDeque.addLast(myClassLinkedList.get(4));
        myClassMDeque.addLast(myClassLinkedList.get(5));
        myClassMDeque.addFirst(myClassLinkedList.get(1));
        myClassMDeque.addFirst(myClassLinkedList.get(0));
        double elapsedNanosMDequeAdd = (double) (System.nanoTime() - startTimeMDequeAdd) / 1000000;
        System.out.println("4.3 Deque based on linked list created");
        System.out.println("\tTime elapsed on adding: " + elapsedNanosMDequeAdd + " milliseconds\n");

        System.out.println("peekFirst()");
        long startTimeMDequePeekF = System.nanoTime();
        myClassMDeque.peekFirst();
        double elapsedNanosMDequePeekF = (double) (System.nanoTime() - startTimeMDequePeekF) / 1000000;
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosMDequePeekF + " milliseconds\n");

        System.out.println("peekLast()");
        long startTimeMDequePeekL = System.nanoTime();
        myClassMDeque.peekLast();
        double elapsedNanosMDequePeekL = (double) (System.nanoTime() - startTimeMDequePeekL) / 1000000;
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosMDequePeekL + " milliseconds\n");

        while (!myClassMDeque.isEmpty()) {
            myClassMDeque.removeFirst();
            if (!myClassMDeque.isEmpty()) {
                myClassMDeque.removeLast();
            }
        }
        System.out.println();

        System.out.println("Deque is empty: " + myClassMDeque.isEmpty() + "\n");

        //Задание 4.4: приоритетная очередь на основе ссылочных типов данных, например, integer, время

        PriorityQueue<String> stringPQueueHobbies = new PriorityQueue<>() {
        };

        long startTimeStringPQueueAdd = System.nanoTime();
        stringPQueueHobbies.add("Swimming");
        stringPQueueHobbies.add("Reading");
        stringPQueueHobbies.add("Travelling");
        stringPQueueHobbies.add("Programming");
        stringPQueueHobbies.add("Cooking");
        double elapsedNanosStringPQueueAdd = (double) (System.nanoTime() - startTimeStringPQueueAdd) / 1000000;
        System.out.println("4.4 Priority Queue based on String created");
        System.out.println("\tTime elapsed on 'addAll': " + elapsedNanosStringPQueueAdd + " milliseconds\n");

        long startTimePQueuePeek = System.nanoTime();
        String peekQ = stringPQueueHobbies.peek();
        double elapsedNanosPQueuePeek = (double) (System.nanoTime() - startTimePQueuePeek) / 1000000;
        System.out.println("peek()");
        System.out.println(peekQ);
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosPQueuePeek + " milliseconds\n");


        while (!stringPQueueHobbies.isEmpty()) {
            System.out.println(stringPQueueHobbies.poll());
        }
        System.out.println("Priority Queue is empty: " + true + "\n");
        System.out.println();

        //Задание 4.5: стек и очередь на базе связанного списка
        Stack<MyClass> myClassStack = new Stack<>();

        long startTimeStackLinkedAdd = System.nanoTime();
        myClassStack.addAll(myClassLinkedList);
        double elapsedNanosStackLinkedAdd = (double) (System.nanoTime() - startTimeStackLinkedAdd) / 1000000;
        System.out.println("4.5 Stack based on linked list created");
        System.out.println("\tTime elapsed on 'addAll': " + elapsedNanosStackLinkedAdd + " milliseconds\n");

        long startTimeStackLinkedPeek = System.nanoTime();
        MyClass peek = myClassStack.peek();
        double elapsedNanosStackLinkedPeek = (double) (System.nanoTime() - startTimeStackLinkedPeek) / 1000000;
        System.out.println("peek()");
        peek.printer();
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosStackLinkedPeek + " milliseconds\n");


        while (!myClassStack.empty()) {
            myClassStack.pop().printer();
        }
        System.out.println("Stack is empty: " + myClassStack.isEmpty() + "\n");
        System.out.println();

        Queue<MyClass> myClassQueue = new LinkedList<>() {
        };

        long startTimeQueueLinkedAdd = System.nanoTime();
        myClassQueue.addAll(myClassLinkedList);
        double elapsedNanosQueueLinkedAdd = (double) (System.nanoTime() - startTimeQueueLinkedAdd) / 1000000;
        System.out.println("4.5 Queue based on linked list created");
        System.out.println("\tTime elapsed on 'addAll': " + elapsedNanosQueueLinkedAdd + " milliseconds\n");

        long startTimeQueueLinkedPeek = System.nanoTime();
        MyClass peekQQ = myClassQueue.peek();
        double elapsedNanosQueueLinkedPeek = (double) (System.nanoTime() - startTimeQueueLinkedPeek) / 1000000;
        System.out.println("peek()");
        assert peekQQ != null;
        peekQQ.printer();
        System.out.println("\tTime elapsed on 'peek': " + elapsedNanosQueueLinkedPeek + " milliseconds\n");


        while (!myClassQueue.isEmpty()) {
            myClassQueue.poll().printer();
        }
        System.out.println("Queue is empty: " + true + "\n");
        System.out.println();
    }

}