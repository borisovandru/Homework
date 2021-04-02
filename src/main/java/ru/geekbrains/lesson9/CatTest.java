package ru.geekbrains.lesson9;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatTest {
    //Создать класс кота, с полями имя, цвет, что-нибудь еще.
    //Создать в базе таблицу с котами.
    //***Сделть класс для работы с котами в бд: запись кота в БД, чтение кота из базы, изменение...

    public static void main(String[] args) {
        CatDBHelper helper = new CatDBHelper();
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Murk", "White"));
        cats.add(new Cat("Baris", "Black"));

        try{
            helper.connect();
            helper.createTable();
            for (Cat c : cats) {
                helper.addCat(c);
            }
            System.out.println("All cats now:");
            for (Cat c : helper.getAllCats()) {
                System.out.println(c);
            }
            System.out.println();
            System.out.println("One cat from db:");
            System.out.println(helper.getCatByName("Baris"));
            System.out.println();
            helper.updateCat("Laska", 1);
            helper.deleteCat(2);
            System.out.println("After delete and update:");
            for (Cat c : helper.getAllCats()) {
                System.out.println(c);
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            helper.closeConnection();
        }
    }
}
