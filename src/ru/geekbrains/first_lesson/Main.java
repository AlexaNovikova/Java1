package ru.geekbrains.first_lesson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // объявление переменных
    int myInt;      //целочисленные типы
    byte myByte;    //целочисленные типы
    long myLong;     //целочисленные типы
    short myShort;    //целочисленные типы
    double myDouble;   // с плавающей точкой
    float myFloat;     // с плавающей точкой
    char myChar;        // символьная переменная
    boolean myBoolean;  // логическая переменная

        // инициализация переменных
    myInt = 10000;
    myByte = 20;
    myLong = 30000000;
    myShort = 999;
    myDouble = 10122.99998;
    myFloat = 309.076f;
    myBoolean = true;
    myChar = '%';
       // определение переменных
    int a = 120;
    int b = 200;
    int c = 233;
    int d = 99;

    checkSign(-233);
    checkSign(b);
    double result = Calculator (a,b,c,d);
        System.out.println( a + "*(" + b + "+(" + c + "/" + d + ")) = " + result );
        System.out.println(" Утверждение, что Сумма чисел " + a + " и " + b + " лежит в пределах от 10 до 20 включительно - это " + checkSum(a,b));
        System.out.println(" Утверждение, что Сумма чисел 12 и 5 лежит в пределах от 10 до 20 включительно - это " + checkSum(12,5));
        System.out.println("Утверждение, о том что число 200 - отрицательное, это " + ifNegative(200));
        System.out.println("Утверждение, о том, что число -40 - отрицательное, это  " + ifNegative(-40));
        greeting("Иван");
        // бесконечный цикл
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Для завершения работы нажмите 0");
            System.out.println("Введите год");
            int year = scanner.nextInt();
            if (year == 0 )
            {
                break;
            }
            ifLeapYear(year);   // проверка , является ли введенный год високосным
        }
    }


  // метод, вычисляющий значение выражения
    public static double Calculator (int a, int b, int c, int d)
    {
        double result = a * (b + ((double)c)/((double)d));
        return result;
    }
  // метод проверяющий что их сумма чисел лежит в пределах от 10 до 20(включительно)
    public static boolean checkSum ( int a , int b) {
        return ((a+b)>=10 && (a+b)<=20);
    }

    // метод, определяющий положительное, либо отрицательное число ему передали
    public static void checkSign (int a) {
        if (a>=0) {
            System.out.println("Число "+ a + " положительное");
        }
        else
            System.out.println("Число " + a + " отрицательное");
    }

    // метод, определяющий является ли число отрицательным
    public static boolean ifNegative (int i){
        return (i<0);
    }

    //метод, выводящий в консоль приветствие
    public static void greeting (String name){
        System.out.println("Привет, " + name + "!");
    }

    // метод, определяющий является ли год високосным
    public static void ifLeapYear ( int year) {
        if ((year % 4 == 0)&&(year % 100 !=0)||(year%400==0)) {
            System.out.println("Год " + year + " является високосным");
        }
        else {
            System.out.println("Год "+ year +" не является високосным");
        }
    }
}

