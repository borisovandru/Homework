package ru.geekbrains.algorithmjava.lesson1;

public class Compare {
    public static void main(String[] args) {
//    Задание 1.1
//    Приготовление чая:
//    Вскипятить чайник, налить заварку, положить сахар, размешать, дать остыть и настояться.
//    Задание 1.2
//    Написание кода:
//    Включить компьютер, запустить программу, написать алгоритм, написать код, скомпилировать.
//    Задания 1.3, 1.4
        Integer a = 1;
        Integer b = 2;
        String Cat1 = "Tom";
        String Cat2 = "Boris";
//        System.out.println("Сравнение Cat1 и Cat2: " +Cat1.compareTo(Cat2));
        System.out.println("a= " + a);
        System.lineSeparator();
        System.out.println("b= " + b);
        System.lineSeparator();
        System.out.println("Cat1= " + Cat1);
        System.lineSeparator();
        System.out.println("Cat2= " + Cat2);
        System.lineSeparator();
        System.out.println("Сравнение Cat1 и Cat2: " + false);
        System.lineSeparator();
        System.out.println("Сравнение a и b: " + a.compareTo(b));
        System.lineSeparator();
        int[] arr = {4, 6, 7, 9, 12, 15, 2, 45, 34,46};

        {
            System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
            }
            System.nanoTime();
        }
    }
}
