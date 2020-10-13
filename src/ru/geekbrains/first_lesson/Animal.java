package ru.geekbrains.first_lesson;

public abstract class Animal {
    protected int age;
    protected String name;
    protected String color;
    protected double jumpHeight;
    protected int runDistance;

    Animal (String name, String color, int age, double jumpHeight, int runDistance) {
        this.age=age;
        this.name=name;
        this.color=color;
        this.jumpHeight=jumpHeight;
        this.runDistance=runDistance;
    }
    abstract void swim(int length);
    abstract void run(int length);
    abstract void jump(double height);
//    abstract void jump();
}
