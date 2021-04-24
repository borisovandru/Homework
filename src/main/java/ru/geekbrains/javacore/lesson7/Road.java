package ru.geekbrains.javacore.lesson7;

public class Road extends Barrier {
    private final int length;

    public Road(String name, int length) {
        super(name);

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("The road " + super.getName() + " length: " + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.println("run successfully");

            return true;
        } else {
            System.out.println("run unsuccessfully");

            return false;
        }
    }
}
