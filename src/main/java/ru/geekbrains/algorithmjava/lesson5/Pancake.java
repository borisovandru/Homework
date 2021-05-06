package ru.geekbrains.algorithmjava.lesson5;

public class Pancake {
    int number;
    String temperature;
    String filling;

    public Pancake(int number, String temperature, String filling) {
        this.number = number;
        this.temperature = temperature;
        this.filling = filling;
    }

    public void printer() {
        String display = "a " + temperature + " pancake with " + filling + " № " + number;
        System.out.println(display);
    }

}
