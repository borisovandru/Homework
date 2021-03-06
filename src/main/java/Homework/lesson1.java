package Homework;

public class lesson1 {

    public static void main(String[] args) {
        //1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
        //где a, b, c, d – целочисленные входные параметры этого метода;
        static double doOne(double a,double b,double c,double d)

        System.out.println("a * (b + (c / d)) = " + doOne(1,2,3,4));
        System.out.println("\nЗадание 2.");

        //3 - 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
        //в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        static boolean doThree ( int a, int b){
            System.out.println("\nЗадание 3.");
            int sum = a + b;
            if (sum > 10 && sum < 20) return true;
            else return false;
        }

        //4 - 5. Написать метод, которому в качестве параметра передается целое число, метод должен
        //напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
        //считаем положительным числом.
        static void doFour ( int a){
            System.out.println("\nЗадание 4.");
            if (a >= 0) System.out.println("Число " + a + "положительное");
            else System.out.println("Число " + a + " отрицательное");
        }

        //5 - 6. Написать метод, которому в качестве параметра передается целое число, метод должен
        //вернуть true, если число отрицательное;
        static boolean doFive ( int a){
            System.out.println("\nЗадание 5.");
            if (a < 0) return true;
            return false;
        }

        //6 - 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        static void doSix (String name){
            System.out.println("\nЗадание 6.");
            System.out.println("Привет, " + name + "!");
        }

        //7 - 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение
        //в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
        //– високосный.
        static void doSeven ( int year){
            System.out.println("\nЗадание 7.");
            if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))
                System.out.println(year + " г. не високосный");
            else System.out.println(year + " г. високосный");
        }
    }


