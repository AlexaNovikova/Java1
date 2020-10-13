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

    @Override
    void run(int length) {
        if (length<=this.runDistance)
        {
            System.out.println(name + " пробежал " + length + " метров/а.");
        }
        else {
            System.out.println(name + " не может пробежать больше " + runDistance + " метров/а.");
        }
    }

    @Override
    void jump(double height) {
        if (height<=this.jumpHeight)
        {
            System.out.println(name + " прыгнул на высоту "+ height +" метров/а.");
        }
        else {
            System.out.println(name+ " не может прыгнуть на высоту больше " + jumpHeight + " метров/а.");
        }
    }

}
