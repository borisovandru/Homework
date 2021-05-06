package ru.geekbrains.algorithmjava.lesson5;

import java.util.Arrays;

public class SortManager {

    public SortManager() {
    }

    //Сортировка слиянием
    public int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)), mergeSort(Arrays.copyOfRange(arr, middle, len)));

    }

    public int[] merge(int[] arrA, int[] arrB) {
        int[] result = new int[arrA.length + arrB.length];
        int aInd = 0;
        int bInd = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = arrA[aInd] < arrB[bInd] ? arrA[aInd++] : arrB[bInd++];
            if (aInd == arrA.length) {
                System.arraycopy(arrB, bInd, result, ++i, arrB.length - bInd);
                break;
            }
            if (bInd == arrB.length) {
                System.arraycopy(arrA, aInd, result, ++i, arrA.length - aInd);
                break;
            }
        }
        return result;
    }

}
