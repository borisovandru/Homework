package ru.geekbrains.algorithmjava.lesson7;

public class Main {
    public static void main(String[] args) {
        //Задание 7.1: пример использования древовидной структуры
        System.out.println("""
                Примеры графов:
                \t- Схемы движения транспорта (метро, поезда, авиация);
                \t- Лабиринты и нахождения кратчайшего пути в них;
                \t- Схемы цепей сообщения;
                \t- Блок-схема программы;
                \t- Генеалогическое древо;
                \t- Нейронные сети;
                \t- Карта сайта;
                \t- Схема распространения COVID-19 для определение контактных групп ))
                """);

        //Задание 7.2: базовые методы графа
        //Граф сделала на базе списков смежности.

        MGraph graph = new MGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G"); //заодно добавили и вершину


        //Задание 7.3: обход в глубину, время
        System.out.println("Depth method:");
        long startTimeDepth = System.nanoTime();
        graph.dfsFull("A");
        double elapsedNanosDepth = (double) (System.nanoTime() - startTimeDepth) / 1000000;
        System.out.println("\tTime elapsed: " + elapsedNanosDepth + " milliseconds\n");

        graph.dfsFull("G");

        //Задание 6.3: обход в ширину, время
        System.out.println("Breadth method:");
        long startTimeBreadth = System.nanoTime();
        graph.bfsFull("A");
        double elapsedNanosBreadth = (double) (System.nanoTime() - startTimeBreadth) / 1000000;
        System.out.println("\tTime elapsed: " + elapsedNanosBreadth + " milliseconds\n");

    }
}