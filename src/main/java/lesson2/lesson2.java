package lesson2;

public class lesson2 {

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("\r\n1 - задание");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 1 ? 0 : 1;
            System.out.print(arr1[i] + " ");
        }

        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\r\n2 - задание");
        int[] arr2 = new int[8];
        for (int i = 1, j = 0; i < arr2.length; i++) arr2[i] = j += 3;
        for (int x : arr2) System.out.print(x + " ");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        System.out.println("\r\n3 - задание");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\r\n4 - задание");
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0, j2 = arr4[i].length; j < arr4[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) arr4[i][j] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.print("\r\n");
        }
        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\r\n5 - задание");
        int[] arr5 = {7, 3, 6, 9, 2, 1, 4, 5, 12, 10, 8, 11};
        int min = arr5[0], max = arr5[0], indMax = 0, indMin = 0;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
                indMax = i;
            }
            if (arr5[i] < min) {
                min = arr5[i];
                indMin = i;
            }
        }
        System.out.println("Максимальный элемент находится в массиве под индексом " + indMax + " со значением  = " + max);
        System.out.println("Минимальный элемент находится в массиве под индексом " + indMin + " со значением  = " + min);
    }
}
