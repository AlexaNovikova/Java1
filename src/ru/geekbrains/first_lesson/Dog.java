package ru.geekbrains.first_lesson;

public class Dog extends Animal {
    Dog (String name, String color, int age, double jumpHeight, int runDistance){
     super(name, color, age, jumpHeight, runDistance);
    }

    @Override
    void swim(int length) {
        if (length<=10)
        {
            System.out.println(name + " проплыл " + length + " метров/а.");
        }
        else {
            System.out.println(name + " не может проплыть больше 10м.");
        }
    }

}
