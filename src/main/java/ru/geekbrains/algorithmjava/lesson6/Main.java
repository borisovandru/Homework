package ru.geekbrains.algorithmjava.lesson6;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Задание 6.1: пример использования древовидной структуры
        System.out.println("""
                Примеры использования древовидной структуры:
                \t- Форматы данных типа json, xml, html;
                \t- Деревья решений в машинном обучении;
                \t- Большинство файловых систем.
                """);

        //Задание 6.2: класс узла дерева и базовый шаблон дерева с базовыми методами
        MoneyTree moneyTree = new MoneyTree();
        System.out.println("Money tree created. The tree is empty: " + moneyTree.isEmpty());

        //Задание 6.3: методы поиска и вставки узла в дерево, время
        long startTimeInsert = System.nanoTime();
        moneyTree.insert(new Coin(10, "ruble", "bronze"));
        double elapsedNanosInsert  = (double) (System.nanoTime() - startTimeInsert)/1000000;
        System.out.println("One coin inserted.");
        System.out.println("\tTime elapsed: " + elapsedNanosInsert + " milliseconds\n");

        moneyTree.insert(new Coin(7, "dinar", "gold"));
        moneyTree.insert(new Coin(2, "cheroots", "gold"));
        moneyTree.insert(new Coin(19, "rupee", "silver"));
        moneyTree.insert(new Coin(17, "dollar", "silver"));
        moneyTree.insert(new Coin(9, "haler", "bronze"));
        moneyTree.insert(new Coin(20, "guilder", "gold"));
        moneyTree.insert(new Coin(4, "shilling", "silver"));
        moneyTree.insert(new Coin(3, "crown", "gold"));
        moneyTree.insert(new Coin(8, "crown", "gold"));

        System.out.println("More coins inserted. The tree is empty: " + moneyTree.isEmpty());

        System.out.print("The root is: ");
        moneyTree.getRoot().getCoin().printer();
        System.out.println();

        int valueToFind = 6;
        long startTimeSearch = System.nanoTime();
        Node nodeFound = moneyTree.findByCoinValue(valueToFind);
        double elapsedNanosSearch  = (double) (System.nanoTime() - startTimeSearch)/1000000;
        System.out.print("Node with value " + valueToFind + ": ");
        if ((nodeFound != null)) {
            nodeFound.getCoin().printer();
        } else {
            System.out.println("not found");
        }
        System.out.println("\tTime elapsed: " + elapsedNanosSearch + " milliseconds\n");

        //Задание 6.4: базовые методы обхода дерева и метода дисплей, поиск максимума и минимума, время
        long startTimeDisplay = System.nanoTime();
        moneyTree.showTree();
        double elapsedNanosDisplay  = (double) (System.nanoTime() - startTimeDisplay)/1000000;
        System.out.println("\tTime elapsed: " + elapsedNanosDisplay + " milliseconds\n");

        long startTimeMax = System.nanoTime();
        Node max = moneyTree.showMax();
        double elapsedNanosMax  = (double) (System.nanoTime() - startTimeMax)/1000000;
        System.out.print("Max: ");
        max.getCoin().printer();
        System.out.println("\tTime elapsed: " + elapsedNanosMax + " milliseconds\n");

        long startTimeMin = System.nanoTime();
        Node min = moneyTree.showMin();
        double elapsedNanosMin = (double) (System.nanoTime() - startTimeMin)/1000000;
        System.out.print("Min: ");
        min.getCoin().printer();
        System.out.println("\tTime elapsed: " + elapsedNanosMin + " milliseconds\n");

        //Задание 6.5: метод удаления, время
        moneyTree.delete(3);
        moneyTree.delete(2);
        moneyTree.delete(7);
        moneyTree.delete(10);
        moneyTree.showTree();

        long startTimeDelete = System.nanoTime();
        moneyTree.delete(19);
        double elapsedNanosDelete  = (double) (System.nanoTime() - startTimeDelete)/1000000;
        System.out.println("Some elements deleted");
        System.out.println("\tTime elapsed: " + elapsedNanosDelete + " milliseconds\n");

        moneyTree.showTree();
        System.out.println();

        //Задание 6.6: алгоритм пирамидальной сортировки с реализацией бинарной пирамиды, время
        int[] arrayToSort;
        arrayToSort = new int[1000];
        Random rand = new Random();
        for (int i = 0; i<1000; i++) {
            arrayToSort[i] = rand.nextInt(1000);
        }
        System.out.println("New array created:");
        System.out.println(Arrays.toString(arrayToSort));

        MyHeap heap = new MyHeap();
        long startTimeHeapSort = System.nanoTime();
        heap.heapSort(arrayToSort);
        double elapsedNanosHeapSort  = (double) (System.nanoTime() - startTimeHeapSort)/1000000;
        System.out.println("Array sorted by heap sort: ");
        System.out.println(Arrays.toString(arrayToSort));
        System.out.println("\tTime elapsed: " + elapsedNanosHeapSort + " milliseconds\n");



        //Задание 6.7: пример сбалансированного дерева и его применения
        System.out.println("""
                Пример сбалансированного дерева:
                \t- Красно-чёрное дерево;
                \t- АВЛ-дерево;
                \t- TreeMap в Java реализован на основе красно-чёрных деревьев.
                """);


    }
}
