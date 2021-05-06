package ru.geekbrains.algorithmjava.lesson5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Задание 5.1: пример использования рекурсии (сама функция в соседнем файле)
        RecursionManager rec = new RecursionManager();

        // Создаём словарь, где ключом выступает имя члена семьи, а значением - имена его отца и матери.
        HashMap<String, String[]> mapBloodTies = new HashMap<>();

        mapBloodTies.put("Vera", new String[]{});  //Прабабушка с дедушкой, у них предков нет (неизвестны)
        mapBloodTies.put("Alexey", new String[]{});

        mapBloodTies.put("Svetlana", new String[]{"Alexey", "Vera"}); // Бабушка с мужем
        mapBloodTies.put("Stepan", new String[]{"Ruslan", "Olga"});
        mapBloodTies.put("Oleg", new String[]{"Stepan", "Svetlana"}); // Их сын

        mapBloodTies.put("Nikolay", new String[]{"Alexey", "Vera"}); // Дедушка с женой и сыном
        mapBloodTies.put("Julia", new String[]{"Valentin", "Inna"});
        mapBloodTies.put("Yuriy", new String[]{"Nikolay", "Julia"}); // Их сын
        mapBloodTies.put("Oksana", new String[]{"Nikolay", "Julia"}); //Их дочь с мужем и дочерью
        mapBloodTies.put("Dmitriy", new String[]{"Grigory", "Yana"});
        mapBloodTies.put("Katya", new String[]{"Dmitriy", "Oksana"}); //Внучка

        //Проверяем, является ли Катя прымым кровным потомком
        System.out.println("Katya is lineal descendant of Grigory: " + rec.isLinealDescendant("Katya", "Grigory", mapBloodTies));
        System.out.println("Katya is lineal descendant of Vera: " + rec.isLinealDescendant("Katya", "Vera", mapBloodTies));
        System.out.println("Katya is lineal descendant of Oleg: " + rec.isLinealDescendant("Katya", "Oleg", mapBloodTies));
        System.out.println("Katya is lineal descendant of Stepan: " + rec.isLinealDescendant("Katya", "Stepan", mapBloodTies));
        System.out.println("Katya is lineal descendant of Yuriy: " + rec.isLinealDescendant("Katya", "Yuriy", mapBloodTies) + "\n");

        /*Задание 5.2: пример бесконечной рекурсии и обычной рекурсии с условием для выхода
           Функция принимает на вход целое число n и по порядку выводит n+1.
           Если убрать ограничение (stop), будет бесконечная рекурсия.*/
        System.out.println("Numbers from 0 to 3 by recursive method:");
        rec.mayBeInternal(0, 3);
        System.out.println();

        //Задание 5.2: пример изображающий стек вызова и стек вызова с рекурсией

        MStack pancakePlate = new MStack();

        pancakePlate.add(new Pancake(1, "hot", "sour cream"));
        pancakePlate.add(new Pancake(2, "hot", "caviar"));
        pancakePlate.add(new Pancake(3, "warm", "honey"));
        pancakePlate.add(new Pancake(4, "warm", "peanut butter"));
        pancakePlate.add(new Pancake(5, "warm", "condensed milk"));
        pancakePlate.add(new Pancake(6, "cold", "jam"));
        System.out.println("Simple stack created");

        while (!pancakePlate.empty()) {
            pancakePlate.pop();
        }
        System.out.println();
        System.out.println("Plate is empty: " + pancakePlate.empty() + "\n");

        MRecursiveStack recursivePlate = new MRecursiveStack();

        recursivePlate.put(new Pancake(1, "hot", "sour cream"));
        recursivePlate.put(new Pancake(2, "hot", "caviar"));
        recursivePlate.put(new Pancake(3, "warm", "honey"));
        recursivePlate.put(new Pancake(4, "warm", "peanut butter"));
        recursivePlate.put(new Pancake(5, "warm", "condensed milk"));
        recursivePlate.put(new Pancake(6, "cold", "jam"));
        System.out.println("Recursive stack created");

        recursivePlate.popAllRecursively();
        System.out.println();
        recursivePlate.peek();
        System.out.println();

        /*Задание 5.4: алгоритм использующий цикл и простой алгоритм использующий рекурсию, время
           Функция из 5.2 и её аналог с циклом вместо рекурсии: */
        System.out.println("Numbers from -5 to 5 by recursive method:");
        long startTimeRec = System.nanoTime();
        rec.mayBeInternal(-5, 5);
        double elapsedNanosRec = (double) (System.nanoTime() - startTimeRec) / 1000000;
        System.out.println("\tTime elapsed: " + elapsedNanosRec + " milliseconds\n");

        System.out.println("Numbers from -5 to 5 by cyclic method:");
        long startTimeCyc = System.nanoTime();
        rec.mayBeInternalCycle(-5, 5);
        double elapsedNanosCyc = (double) (System.nanoTime() - startTimeCyc) / 1000000;
        System.out.println("\tTime elapsed: " + elapsedNanosCyc + " milliseconds\n");

        //Задание 5.6: алгоритм сортировки слиянием, время по сравнению с сортировкой методом sort()

        SortManager sorter = new SortManager();
        int[] arrayToSortAndSearch;
        arrayToSortAndSearch = new int[1000];

        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            arrayToSortAndSearch[i] = rand.nextInt(1000);
        }

        int[] arrayToSortAndSearchCopy = arrayToSortAndSearch.clone();

        System.out.println("Unsorted array: " + Arrays.toString(arrayToSortAndSearch));
        long startTimeMergeSort = System.nanoTime();
        int[] arrayToSortSorted = sorter.mergeSort(arrayToSortAndSearch);
        double elapsedNanosMergeSort = (double) (System.nanoTime() - startTimeMergeSort) / 1000000;
        System.out.println("2.3.2. Array sorted by 'mergeSort()': " + Arrays.toString(arrayToSortSorted));
        System.out.println("\tTime elapsed: " + elapsedNanosMergeSort + " milliseconds\n");

        System.out.println("Unsorted array copy: " + Arrays.toString(arrayToSortAndSearchCopy));
        long startTimeSort = System.nanoTime();
        Arrays.sort(arrayToSortAndSearchCopy);
        double elapsedNanosSort = (double) (System.nanoTime() - startTimeSort) / 1000000;
        System.out.println("2.3.2. Array sorted by 'sort()': " + Arrays.toString(arrayToSortAndSearchCopy));
        System.out.println("\tTime elapsed: " + elapsedNanosSort + " milliseconds\n");

        //Задание 5.5: алгоритм двоичного рекурсивного поиска на основе массива, время по сравнению с обычным двоичным поиском
        SearchManager finder = new SearchManager();

        long startTimeRecursiveBinarySearch = System.nanoTime();
        int index = finder.recursiveBinarySearch(arrayToSortAndSearch, 36, 0, arrayToSortAndSearch.length-1);
        double elapsedNanosRecursiveBinarySearch = (double) (System.nanoTime() - startTimeRecursiveBinarySearch) / 1000000;
        System.out.println("Recursive binary Search found element at index: " + index);
        System.out.println("\tTime elapsed: " + elapsedNanosRecursiveBinarySearch + " milliseconds\n");

        long startTimeBinarySearch = System.nanoTime();
        int indexR = finder.binarySearch(arrayToSortAndSearch, 36);
        double elapsedNanosBinarySearch = (double) (System.nanoTime() - startTimeBinarySearch) / 1000000;
        System.out.println("Simple binary Search found element at index: " + indexR);
        System.out.println("\tTime elapsed: " + elapsedNanosBinarySearch + " milliseconds\n");
    }
}
