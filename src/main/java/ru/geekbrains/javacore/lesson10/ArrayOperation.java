package ru.geekbrains.javacore.lesson10;


import java.io.*;
import java.util.*;


public class ArrayOperation{  static void fillTheArray(List<String> array) {
        array.add("hello");
        array.add("Hello");
        array.add("car");
        array.add("boy");
        array.add("world");
        array.add("World");
        array.add("hi");
        array.add("bye");
        array.add("Bye");
        array.add("bye");
}
public static void fillTheArrayFromFile(List<String> array, String fileName) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
        buffer.append(reader.readLine()).append("\n");
        }
        if(buffer.length() > 0) {
        String[] tempArr = buffer.toString().split(" ");
                Collections.addAll(array, tempArr);
        }
}

public static void printUniqueWords(List<String> array) {
        Set<String> tempArray = new LinkedHashSet<>();
        for (String arr : array) {
        String a = arr.toLowerCase();
        tempArray.add(a);
        }
        for (String tempArr : tempArray) {
        int count = 0;
        for (String arr : array) {
        String a = arr.toLowerCase();
        if(tempArr.equals(a)) count++;
        }
        System.out.println("\"" + tempArr + "\"" + " repeated in the list = " + count);
        }
        System.out.println();
        }
        }
