package ru.geekbrains.algorithmjava.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Задание 2.1: реализуем массив
        int[] arrayToCopyAndCompare;
        arrayToCopyAndCompare = new int[1000];

        Random rand = new Random();
        for (int i = 0; i<1000; i++) {
            arrayToCopyAndCompare[i] = rand.nextInt(1000);
        }

        //Задание 2.1: базовые операции класса Arrays, время выполнения
        long startTimeString = System.nanoTime();
        String arrayToSortAsString = Arrays.toString(arrayToCopyAndCompare);
        double elapsedNanosString = (double) (System.nanoTime() - startTimeString)/1000000;
        System.out.println("2.1.1. Printed array: " + arrayToSortAsString);
        System.out.println("\tTime elapsed on 'Arrays.toString': " + elapsedNanosString + " milliseconds\n");

        long startTimeCopy = System.nanoTime();
        int[] arrayCopy = Arrays.copyOf(arrayToCopyAndCompare, arrayToCopyAndCompare.length);
        double elapsedNanosCopy = (double) (System.nanoTime() - startTimeCopy)/1000000;
        System.out.println("2.1.2. Copied array: " + Arrays.toString(arrayCopy));
        System.out.println("\tTime elapsed on 'Arrays.copyOf': " + elapsedNanosCopy + " milliseconds\n");

        long startTimeCompare = System.nanoTime();
        int arrayCompare = Arrays.compare(arrayToCopyAndCompare, arrayCopy);
        double elapsedNanosCompare = (double) (System.nanoTime() - startTimeCompare)/1000000;
        System.out.println("2.1.3. Arrays are equal: " + arrayCompare);
        System.out.println("\tTime elapsed on 'Arrays.compare': " + elapsedNanosCompare + " milliseconds\n");

        //Задание 2.2: линейный поиск (поиск реализован в классе SearchManager)
        SearchManager finder = new SearchManager();
        Arrays.sort(arrayToCopyAndCompare); //Сортируем для наглядности

        long startTimeLinearSearch = System.nanoTime();
        int indexL = finder.linearSearch(arrayToCopyAndCompare, 36);
        double elapsedNanosLinearSearch = (double) (System.nanoTime() - startTimeLinearSearch)/1000000;
        System.out.println("2.2.1. Linear Search found element at index: " + indexL);
        System.out.println("\tTime elapsed: " + elapsedNanosLinearSearch + " milliseconds\n");

        //Задание 2.2: двоичный поиск поиск (поиск реализован в классе SearchManager)
        long startTimeBinarySearch = System.nanoTime();
        int indexB = finder.binarySearch(arrayToCopyAndCompare, 36);
        double elapsedNanosBinarySearch = (double) (System.nanoTime() - startTimeBinarySearch)/1000000;
        System.out.println("2.2.2. Binary Search found element at index: " + indexB);
        System.out.println("\tTime elapsed: " + elapsedNanosBinarySearch + " milliseconds\n");

        //Задание 2.3: массив размером 400 элементов, сортировка sort() и время выполнения
        int[] arrayToSort;
        arrayToSort = new int[400];
        for (int i = 0; i<400; i++) {
            arrayToSort[i] = rand.nextInt(1000);
        }
        System.out.println("2.3.1. Unsorted array: " + Arrays.toString(arrayToSort));

        int[] arrayToSortCopy1 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        int[] arrayToSortCopy2 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        int[] arrayToSortCopy3 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        int[] arrayToSortCopy4 = Arrays.copyOf(arrayToSort, arrayToSort.length);

        long startTimeSort= System.nanoTime();
        Arrays.sort(arrayToSort);
        double elapsedNanosSort = (double) (System.nanoTime() - startTimeSort)/1000000;
        System.out.println("2.3.2. Array sorted by 'sort()': " + Arrays.toString(arrayToSort));
        System.out.println("\tTime elapsed: " + elapsedNanosSort + " milliseconds\n");

        //Задание 2.4: сортировка пузырьком (сортировка реализована в классе SortManager)
        SortManager sorter = new SortManager();
        System.out.println("2.4.1. Unsorted array copy1: " + Arrays.toString(arrayToSortCopy1));
        long startTimeSortBubble= System.nanoTime();
        int[] arrayToSortCopy1Sorted = sorter.bubbleSort(arrayToSortCopy1);
        double elapsedNanosSortBubble = (double) (System.nanoTime() - startTimeSortBubble)/1000000;
        System.out.println("2.4.2. Array sorted by bubble sort: " + Arrays.toString(arrayToSortCopy1Sorted));
        System.out.println("\tTime elapsed: " + elapsedNanosSortBubble + " milliseconds\n");

        //*Сортировка пузырьком улучшенная (шейкерная)
        System.out.println("*Unsorted array copy1: " + Arrays.toString(arrayToSortCopy4));
        long startTimeSortBubble2= System.nanoTime();
        int[] arrayToSortCopy4Sorted = sorter.bubbleSort(arrayToSortCopy4);
        double elapsedNanosSortBubble2 = (double) (System.nanoTime() - startTimeSortBubble2)/1000000;
        System.out.println("*Array sorted by upgraded bubble sort: " + Arrays.toString(arrayToSortCopy4Sorted));
        System.out.println("\tTime elapsed: " + elapsedNanosSortBubble2 + " milliseconds\n");


        //Задание 2.5: сортировка методом выбора (сортировка реализована в классе SortManager)
        System.out.println("2.5.1. Unsorted array copy2: " + Arrays.toString(arrayToSortCopy2));
        long startTimeSortSelection= System.nanoTime();
        int[] arrayToSortCopy2Sorted = sorter.selectionSort(arrayToSortCopy2);
        double elapsedNanosSortSelection = (double) (System.nanoTime() - startTimeSortSelection)/1000000;
        System.out.println("2.5.2. Array sorted by selection sort: " + Arrays.toString(arrayToSortCopy2Sorted));
        System.out.println("\tTime elapsed: " + elapsedNanosSortSelection + " milliseconds\n");

        //Задание 2.6: сортировка методом вставки (сортировка реализована в классе SortManager)
        System.out.println("2.6.1. Unsorted array copy3: " + Arrays.toString(arrayToSortCopy3));
        long startTimeSortInsertion= System.nanoTime();
        int[] arrayToSortCopy3Sorted = sorter.insertionSort(arrayToSortCopy3);
        double elapsedNanosSortInsertion = (double) (System.nanoTime() - startTimeSortInsertion)/1000000;
        System.out.println("2.6.2. Array sorted by insertion sort: " + Arrays.toString(arrayToSortCopy3Sorted));
        System.out.println("\tTime elapsed: " + elapsedNanosSortInsertion + " milliseconds\n");
    }
}

