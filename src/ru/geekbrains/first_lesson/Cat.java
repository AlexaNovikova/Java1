package ru.geekbrains.first_lesson;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety=false;
    }
    public void eat(Plate p) {
        if (this.appetite<=p.getFood()) {
            p.decreaseFood(appetite);
            this.satiety = true;
            appetite=0;
        }
    }
    public void catInfo(){
        System.out.println(name + ": аппетит- " + appetite + ", сытость- "+ satiety);
    }
}
