package ru.geekbrains.lesson6;

public class Plate {
    private int food;

    public Plate(int n) {
        food = n < 0 ? -n : n;
        info();
    }

    public int getFood() {
        return food;
    }

    boolean decreaseFood(int n) {
        if (n > food) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void info() {
        System.out.printf("В тарелке %d единиц еды\n\n", food);
    }
}
