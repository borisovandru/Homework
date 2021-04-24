package ru.geekbrains.javacore.lesson5;

public class Animal {
    private static int counter;
    private final String type;
    private final String name;
    private final int maxRunDistance;
    private final int maxSwimDistance;

    public Animal(String type, String name, int maxRun, int maxSwim) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRun;
        this.maxSwimDistance = maxSwim;
        counter++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.printf("%s %s run %d meters\r\n", type, name, distance);
        } else System.out.printf("%s %s could not run %d meters\r\n", type, name, distance);
    }

    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.printf("%s %s swam %d meters\r\n", type, name, distance);
        } else System.out.printf("%s %s could not swim %d meters\r\n", type, name, distance);
    }

    public String getName() {
        return name;
    }

    public static int getCounter() {
        return counter;
    }

}