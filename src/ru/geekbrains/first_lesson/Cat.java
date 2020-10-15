package ru.geekbrains.first_lesson;

public class Cat extends Animal {
    Cat (String name, String color, int age, double jumpHeight, int runDistance)
    {
        super(name,color,age,jumpHeight, runDistance);
    }

    @Override
    void swim(int length) {
        System.out.println("Кошки не умеют плавать.");
    }

}
