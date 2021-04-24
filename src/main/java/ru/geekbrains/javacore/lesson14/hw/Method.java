package ru.geekbrains.javacore.lesson14.hw;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Method {

    public int[] myMethodOne(int[] array) {


        int[] newArray = ArrayUtils.subarray(array,
                ArrayUtils.lastIndexOf(array, 4) + 1,
                ArrayUtils.getLength(array)+1);
        if (Arrays.equals(array, newArray)) throw new RuntimeException();
        return newArray;
    }
    public boolean myMethodTwo(int[] array) {
        return  (ArrayUtils.contains(array, 1) || ArrayUtils.contains(array, 4));
    }
}
