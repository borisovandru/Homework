package ru.geekbrains.lesson7;

public class Wall extends Barrier {

    private final int height;

    public Wall(String name, int height) {
        super(name);

        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("The wall " + super.getName() + "height: " + this.height);

        actions.jump();

        if (getHeight() <= actions.getJumpHeight()) {
            System.out.println("jump successfully");

            return true;
        } else {
            System.out.println("jump unsuccessfully");

            return false;
        }
    }
}