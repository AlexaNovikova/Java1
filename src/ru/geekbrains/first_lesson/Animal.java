package ru.geekbrains.first_lesson;

public abstract class Animal {
    protected int age;
    protected String name;
    protected String color;
    protected double jumpHeight;
    protected int runDistance;

    Animal(String name, String color, int age, double jumpHeight, int runDistance) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    abstract void swim(int length);

    void run(int length) {
        if (length <= this.runDistance) {
            System.out.println(name + " пробежал/а " + length + " метров/а.");
        } else {
            System.out.println(name + " не может пробежать больше " + runDistance + " метров/а.");
        }
    }

    void jump(double height) {
        if (height <= this.jumpHeight) {
            System.out.println(name + " прыгнул/а на высоту " + height + " метров/а.");
        } else {
            System.out.println(name + " не может прыгнуть на высоту больше " + jumpHeight + " метров/а.");
        }
    }
}