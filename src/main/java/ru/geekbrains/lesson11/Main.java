package ru.geekbrains.lesson11;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Задача 1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);
        String[] arr = {"table", "apple", "fruit", "cool"};


        System.out.println("Task 1\n" + Arrays.toString(arr));
        swapElements(arr);
        System.out.println(Arrays.toString(arr));


        //Задача 2. Написать метод, который преобразует массив в ArrayList
        List<String> list = convertToList(arr);
        System.out.println("Task 2\n" + list.getClass() + " : " + list);


        //Задача 3. Коробки с фруктами
        System.out.println("Task 3");
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        float orange1Weight = orangeBox1.getWeight();
        float orange2Weight = orangeBox2.getWeight();
        float appleWeight = appleBox.getWeight();
        System.out.println("Вес коробки 1 с апельсинами: " + orange1Weight);
        System.out.println("Вес коробки 2 с апельсинами: " + orange2Weight);
        System.out.println("Вес коробки с яблоками: " + appleWeight);

        System.out.println("Сравнить вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Сравнить вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox));

        orangeBox1.moveAt(orangeBox2);


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();
    }

    private static <T> void swapElements(T[] array) {
        T temp = array[2];
        array[2] = array[3];
        array[3] = temp;
    }

    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
