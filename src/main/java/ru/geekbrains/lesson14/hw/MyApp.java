package ru.geekbrains.lesson14.hw;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

//Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен
// вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней
// четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
//Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

//Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то
// метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//[ 1 1 1 4 4 1 4 4 ] -> true
//[ 1 1 1 1 1 1 ] -> false
//[ 4 4 4 4 ] -> false
//[ 1 4 4 1 1 4 3 ] -> false

public class MyApp {

    public static void main(String[] args) {
        int[] array = {1,2,4,4,2,3,4,1,7};
        Method method = new Method();
        System.out.println(Arrays.toString(method.myMethodOne(array)));
        System.out.println(method.myMethodTwo(method.myMethodOne(array)));


        Connection conn = null;

        Statement stmt = null;
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            String dbUrl = null;
            String user = null;
            String password = null;
            assert false;
            conn = DriverManager.getConnection(dbUrl, user, password);
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                assert false;
                conn.close();
                assert stmt != null;
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class Driver implements java.sql.Driver {
        @Override
        public Connection connect(String url, Properties info) {
            return null;
        }

        @Override
        public boolean acceptsURL(String url) {
            return false;
        }

        @Override
        public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
            return new DriverPropertyInfo[0];
        }

        @Override
        public int getMajorVersion() {
            return 0;
        }

        @Override
        public int getMinorVersion() {
            return 0;
        }

        @Override
        public boolean jdbcCompliant() {
            return false;
        }

        @Override
        public Logger getParentLogger() {
            return null;
        }
    }
}
