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

    @Override
    void run(int length) {
        if (length<=this.runDistance)
        {
            System.out.println(name + " пробежала " + length + " метров/а.");
        }
        else {
            System.out.println(name + " не может пробежать больше " + runDistance + " метров/а.");
        }

    }

    @Override
    void jump(double height) {
        if (height<=this.jumpHeight)
        {
            System.out.println(name + " прыгнула на высоту "+ height +" метров/а.");
        }
        else {
            System.out.println(name+ " не может прыгнуть на высоту больше "+ jumpHeight + " метров/а.");
        }
    }
}
