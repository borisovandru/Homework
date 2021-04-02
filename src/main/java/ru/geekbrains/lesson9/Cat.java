package ru.geekbrains.lesson9;

public class Cat {
    private long id;
    private String name;
    private final String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat # " + id + " " + name + " " + color;
    }
}

