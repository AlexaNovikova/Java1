package ru.geekbrains.first_lesson;

import java.util.Random;
import java.util.Scanner;
//1. Расширить задачу про котов и тарелки с едой
//        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
//        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

public class Main {

    public static final int MAXAPPETITE=10;
    public static final int MAXKOLFOOD=20;
    public static final int MINKOLFOOD=6;
    public static final int KOLCATS=7;
    public static Cat[] cats;

    public static void main(String[] args) {
        Cat [] cats = new Cat[KOLCATS];
        for(int i=0; i<KOLCATS; i++)
        {
         cats[i]=createCat();
        }
        Plate plate = createPlate();
        System.out.println("До еды.");
        plate.info();
        printInfo(cats);

        for (int i=0; i< cats.length; i++)
        {
            cats[i].eat(plate);
        }
        System.out.println();
        System.out.println("Коты поели в перый раз");
        plate.info();
        printInfo(cats);
        plate.addFood(MAXKOLFOOD-plate.getFood());

        System.out.println("В тарелку добавили еды, теперь еды: " +plate.getFood());

        for (int i=0; i< cats.length; i++)
        {
            cats[i].eat(plate);
        }
        System.out.println();
        System.out.println("Коты поели второй раз");
        plate.info();
        printInfo(cats);

    }

        static Cat createCat () {
        Random rand = new Random();
        String [] names = {"Маша", "Даша", "Дуся","Барсик","Вася","Снежок","Пушок","Сима"};
        Cat cat=new Cat(names[rand.nextInt(8)], rand.nextInt(MAXAPPETITE)+1);
        return cat;
    }
        static Plate createPlate (){
        Random rand = new Random();
        Plate plate = new Plate(rand.nextInt(MAXKOLFOOD-MINKOLFOOD+1)+MINKOLFOOD);
        return plate;
    }
        static void printInfo(Cat[] cats){
            for (int i=0; i< cats.length; i++)
            {
                cats[i].catInfo();
            }
        }
}

