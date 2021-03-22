package ru.geekbrains.lesson6;

public class Cat {
    private final String name;
    private final int appetite;                   // сколько кот съедает за один подход к тарелке
    private int saturationFood;             // насыщение кота едой - сколько кот съел единиц еды - увеличивается на appetite за каждый подход к тарелке
    private final int catFullness;                // сколько коту нужно съесть до полного насыщения
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.saturationFood = 0;                    // насыщение кота едой на нуле
        this.fullness = false;                      // кот изначально голодный
        this.catFullness = this.appetite * 4;
    }

    public int getSaturationFood() {
        return saturationFood;
    }

    public int getCatFullness() {
        return catFullness;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void eat(Plate p) {
        if (this.fullness) {
            return;
        }
        if (p.decreaseFood(this.appetite)) {
            System.out.printf("%s съел %d единиц еды\n", this.name, this.appetite);
            this.saturationFood += this.appetite;
            if (this.saturationFood == this.catFullness) {                              // если кот насытился до состояния насыщения -
                this.fullness = true;                                                   // устанавливаем насыщение в true
            }
        }
    }
}
