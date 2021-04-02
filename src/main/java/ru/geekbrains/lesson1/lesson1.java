package ru.geekbrains.lesson1;

public class lesson1 {

    public static void main(String[] args) {
        //1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
        //где a, b, c, d – целочисленные входные параметры этого метода;
        int a = 7;
        int b = 7;
        int c = 3;
        int d = 8;
    }

    public static double doOne(double a, double b, double c, double d) {
        System.out.println("\nЗадание 1.");
        return a * (b + (c / d));
    }

    //2. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
        //в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        static boolean doTwo ( int a, int b){
            System.out.println("\nЗадание 2.");
            int sum = a + b;
            return sum > 10 && sum < 20;
        }

        //3. Написать метод, которому в качестве параметра передается целое число, метод должен
        //напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
        //считаем положительным числом.
        static void doThree ( int a){
            System.out.println("\nЗадание 3.");
            if (a >= 0) System.out.println("Число " + a + "положительное");
            else System.out.println("Число " + a + " отрицательное");
        }

        //4. Написать метод, которому в качестве параметра передается целое число, метод должен
        //вернуть true, если число отрицательное;
        static boolean doFour ( int a){
            System.out.println("\nЗадание 4.");
            return a < 0;
        }

        //5. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        static void doFive (String name){
            System.out.println("\nЗадание 5.");
            System.out.println("Привет, " + name + "!");
        }

        //6. * Написать метод, который определяет является ли год високосным, и выводит сообщение
        //в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
        //– високосный.
        static void doSix ( int year){
            System.out.println("\nЗадание 6.");
            if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))
                System.out.println(year + " г. не високосный");
            else System.out.println(year + " г. високосный");
        }
    }


