package ru.geekbrains.algorithmjava.lesson2;

public class SortManager {

    public SortManager() {}

    //Сортировка пузырьком
    public int[] bubbleSort(int[] arr) {
        int numberOfShifts = 1;
        while (numberOfShifts != 0) {
            numberOfShifts = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]){
                    numberOfShifts += 1;
                    int buff = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                }
            }
        }
        return arr;
    }

    //Удучшенная сортировка пузырьком
    public int[] bubbleSortUpgraded(int[] arr) {
        int lastIndex = arr.length-1;
        int firstIndex = 0;
        int numberOfShifts = 1;
        while (numberOfShifts != 0) {
            numberOfShifts = 0;
            for (int i = firstIndex; i < lastIndex; i++) {
                if (arr[i] > arr[i+1]){
                    numberOfShifts += 1;
                    int buff = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                }
            }
            lastIndex--;
            for (int i = lastIndex+1; i > firstIndex; i--) {
                if (arr[i] < arr[i-1]){
                    numberOfShifts += 1;
                    int buff = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = buff;
                }
            }
            firstIndex++;
        }
        return arr;
    }
    //Сортировка методом выбора
    public int[] selectionSort(int[] arr) {
        int min;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] <= min) {
                    min = arr[j];
                    index = j;
                }
            }
            int buff = arr[i];
            arr[i] = min;
            arr[index] = buff;
        }
        return arr;
    }

    //Сортировка методом вставки
    public int[] insertionSort(int[] arr) {
        int el;
        for (int i = 1; i < arr.length; i++) {
            el = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (arr[j] > el) {
                    arr[j+1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j+1] = el;
        }
        return arr;
    }
}
