package ru.geekbrains.lesson5;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому
        методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака
        0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
        4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например,
        dog1.run(150); -> результат: run: true)
        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м.,
        у другой 600 м.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);

        double distanceRun = Math.random() * 500;
        double distanceJump = Math.random() * 3;
        double distanceSwim = Math.random() * 0;
        Cat cat = new Cat(distanceRun, distanceJump, distanceSwim);

        distanceRun = Math.random()*2000;
        distanceJump = Math.random()*2;
        distanceSwim = Math.random()*100;
        Animal dog = new Dog(distanceRun, distanceJump, distanceSwim);


        System.out.println("Кошка может пробежать: " + cat.getAnimalDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить run(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Собака пытается выполнить run(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может прыгнуть: " + cat.getAnimalDistanceJump() +
                " м. \nСобака может прыгнуть: " + dog.getAnimalDistanceJump() + " м.");

        System.out.println("Введите высоту препятствия:");
        distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить jump(" + distance + "). Результат: " + cat.jump(distance));
        System.out.println("Собака пытается выполнить jump(" + distance + "). Результат: " + dog.jump(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может проплыть: " + cat.getAnimalDistanceSwim() +
                " м. \nСобака может проплыть: " + dog.getAnimalDistanceSwim() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить swim(" + distance + "). Результат: " + cat.swim(distance));
        System.out.println("Собака пытается выполнить swim(" + distance + "). Результат: " + dog.swim(distance));

    }


}
