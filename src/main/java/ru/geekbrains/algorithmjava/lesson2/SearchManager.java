package ru.geekbrains.algorithmjava.lesson2;

public class SearchManager {

    public SearchManager() {
    }

    //Линейный поиск
    public int linearSearch(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1; //If nothing is found
    }

    //Двоичный поиск поиск
    public int binarySearch(int[] arr, int elem) {
        int elemToBegin = 0;
        int elemToEnd = arr.length - 1;
        while (elemToBegin <= elemToEnd) {
            int middleElemIndex = (elemToBegin + elemToEnd) / 2;
            if(arr[middleElemIndex] == elem){
                return middleElemIndex;
            }
            else if(arr[middleElemIndex] < elem){
                elemToBegin = middleElemIndex + 1;
            }
            else if(arr[middleElemIndex] > elem){
                elemToEnd = middleElemIndex - 1;
            }
        }
        return -1; //If nothing is found
    }
}