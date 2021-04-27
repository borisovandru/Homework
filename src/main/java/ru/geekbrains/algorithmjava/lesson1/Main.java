package ru.geekbrains.algorithmjava.lesson1;

public class Main {
    public static void main(String[] args) {
        MyClass myItemDress = new MyClass(
                5,
                'S',
                864.80,
                true,
                "Dress",
                new String[]{"green", "blue", "pink"});

        myItemDress.printer();

        //Compare to another instance:
        MyClass myItemSkit = new MyClass(4, 'S', 1499.0, true, "Skirt", new String[]{"black", "blue"});
        long startTime = System.nanoTime();
        System.out.println("2. Equals to different instance: " + myItemSkit.equals(myItemDress)); //false
        double elapsedNanos = (double) (System.nanoTime() - startTime)/1000000;
        System.out.println("\tTime elapsed: " + elapsedNanos + " milliseconds\n");

        //Compare to an identical instance:
        MyClass myItemDressCopy = new MyClass(myItemDress.id, myItemDress.quantity, myItemDress.size, myItemDress.price, myItemDress.inStock, myItemDress.name, myItemDress.coloursAvailable);
        long startTime2 = System.nanoTime();
        System.out.println("2. Equals to an identical instance: " + myItemDressCopy.equals(myItemDress)); //true
        double elapsedNanos2 = (double) (System.nanoTime() - startTime2)/1000000;
        System.out.println("\tTime elapsed: " + elapsedNanos2 + " milliseconds");
    }
}
