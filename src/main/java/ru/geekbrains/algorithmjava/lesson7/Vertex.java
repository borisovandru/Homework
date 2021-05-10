package ru.geekbrains.algorithmjava.lesson7;

public class Vertex {
    public String label;
    public boolean alreadyCovered;
    public int timesCovered;

    public Vertex(String label) {
        this.label = label;
        this.alreadyCovered = false;
        this.timesCovered = 0;
    }
}
