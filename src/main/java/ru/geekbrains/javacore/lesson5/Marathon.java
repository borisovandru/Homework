package ru.geekbrains.javacore.lesson5;

class Marathon {
    public static void main(String[] args) {
        //Создать классы Собака и Кот с наследованием от класса Животное.
        //Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        // Результатом выполнения действия будет печать в консоль.
        // (Например, dogBobbin.run(150); -> 'Бобик пробежал 150 м.');
        //У каждого животного есть ограничения на действия
        // (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        //Добавить подсчет созданных котов, собак и животных.
        Animal[] animals = {
                new Cat("Baris"),
                new Cat("Murk"),
                new Cat("Muir"),
                new Dog("Bobbin", 500, 20),
                new Dog("Tusk", 300, 15),
                new Dog("Shark", 400, 30),
                new Dog("kruskal", 200, 50)
        };

        for (Animal a : animals) {
            a.run(200);
            a.swim(10);
            a.run(500);
            a.swim(15);
            a.run(1000);
            a.swim(30);

        }

        Cat o = new Cat("");

        o.swim(100);

        System.out.println("There were " + Cat.getCounter() + " Cats");
        System.out.println("There were " + Dog.getCounter() + " Dogs");
        System.out.println("There were " + Animal.getCounter() + " Animals");

    }
}
