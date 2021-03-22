package ru.geekbrains.lesson6;

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

import java.util.Scanner;

public class Feeding {
    public static void main(String[] args) {
        Cat[] pets = {
                new Cat("Barsik", 2),
                new Cat("Murzik", 7),
                new Cat("Markiz", 5),
                new Cat("Tom", 3),
                new Cat("Pushok", 1),
                new Cat("Snezhok", 2),
                new Cat("Vas'ka", 5),
                new Cat("Bonya", 4)
        };
        System.out.println("Укажите первоначальное количество еды в миске:");
        Plate plate = new Plate(new Scanner(System.in).nextInt());

        for (Cat c : pets) {
            while (!c.isFullness() && plate.getFood() >= c.getAppetite()) {     // если кот ещё не сыт и в миске лежит больше, чем кот съедает за раз -
                c.eat(plate);                                                   // кот ест из тарелки
                plate.info();
            }

        }
        for (Cat c : pets) {
            if (c.isFullness()) {
                System.out.printf("%s наелся\n", c.getName());
            } else {
                System.out.printf("%s остался голодным, ему не хватило %d единиц еды\n", c.getName(), c.getCatFullness() - c.getSaturationFood());
            }
        }
    }
}