package ru.geekbrains.lesson10;

import java.io.IOException;
import java.util.*;


class Main {

    private static final String FILE_NAME2;

    static {
        FILE_NAME2 = " C: JAVA/Java2Lesson3Homework3.txt ";
    }

    private static final String FILE_NAME1 = " Java2Lesson3Homework3.txt ";

    /**
     * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
     * уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое
     * слово.
     * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
     * номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
     * однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
     * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
     * дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль
     * желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
     */

    public static void main(String[] args) {

        List<String> wordArray = new ArrayList<>();
        ArrayOperation.fillTheArray(wordArray);

        System.out.println(wordArray + "\n");
        ArrayOperation.printUniqueWords(wordArray);
        wordArray.clear();
        try {
            ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME2);
        } catch (IOException e) {
            System.out.println("Failed to fill array from file!\n");
        }
        try {
            ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME1);
        } catch (IOException e) {
            System.out.println("Failed to fill array from file!\n");
        }
        System.out.println(wordArray + "\n");
        ArrayOperation.printUniqueWords(wordArray);

        Phonebook phonebook = new Phonebook();

        phonebook.add(2312512, "Ivanov");
        phonebook.add(5678794, "Ivanov");
        phonebook.add(3456783, "Petrov");
        phonebook.add(3456278, "Suvorov");
        phonebook.add(9786053, "Suvorov");
        phonebook.add(6475893, "Suvorov");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Suvorov");
        phonebook.get("Lebedev");
    }
}
