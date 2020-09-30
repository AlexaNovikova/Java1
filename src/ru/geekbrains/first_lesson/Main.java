package ru.geekbrains.first_lesson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // первое задание [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]

        int[] mass = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Вывод элементов массива до внесения изменений");
        printMass(mass);
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 0) {
                mass[i] = 1;
            } else mass[i] = 0;
        }
        System.out.println("Вывод элементов массива после изменений");
        printMass(mass);

        System.out.println();

        // второе задание

        int[] mass2 = new int[8];
        for (int i = 1; i < mass2.length; i++) {
            mass2[i] = mass2[i - 1] + 3;
        }
        System.out.println("Вывод заполненного массива к задаче 2");
        printMass(mass2);
        System.out.println();


        // третье задание
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] mass3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив к задаче 3");
        printMass(mass3);
        for (int i = 0; i < mass3.length; i++) {
            if (mass3[i] < 6) {
                mass3[i] = 2 * mass3[i];
            }
        }
        System.out.println("Массив после умножения всех чисел меньше 6 на 2");
        printMass(mass3);
        System.out.println();


        // четвертое задание
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] massQuadr = new int[10][10];
        System.out.println("Квадратный массив к задаче 4");
        for (int i = 0; i < massQuadr.length; i++) {
            for (int j = 0; j < massQuadr[i].length; j++) {
                if ((i == j) || (i == massQuadr.length - 1 - j)) {
                    massQuadr[i][j] = 1;
                }
            }

            printMass(massQuadr[i]);
        }
        System.out.println();


        // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        int[] mass4 = new int[20];
        for (int i = 0; i < mass4.length; i++) {
            mass4[i] = (int) (Math.random() * 100);
        }
        System.out.println("Задача 5");
        System.out.println("Одномерный массив, заполненный случайными числами");
        printMass(mass4);
        printMinAndMaxInMass(mass4);
        System.out.println();

        // Задание 6

        System.out.println("Проверка массива из задачи 5");
        if (checkBalance(mass4)) {
            System.out.println("В массиве есть место, в котором сумма левой и правой части массива равны.");
        } else {
            System.out.println("В массиве нет места, в котором сумма левой и правой части массива равны.");
        }
        System.out.println("Проверка массива из задачи 3");
        if (checkBalance(mass3)) {
            System.out.println("В массиве есть место, в котором сумма левой и правой части массива равны.");
        } else {
            System.out.println("В массиве нет места, в котором сумма левой и правой части массива равны.");
        }
        System.out.println();

        // Задание 7
        System.out.println(" Задача 7. Исходный массив:");
        printMass(mass4);
        System.out.println("Смещение элементов массива на 3 позиции вправо");
        changeMass(mass4, 3);
        printMass(mass4);
        System.out.println("Смещение элементов массива на 5 позиции влево");
        changeMass(mass4, -5);
        printMass(mass4);

    }


    // вывод элементов массива в консоль
    public static void printMass(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }

    // метод, выводящий в консоль минимальный и максимальный элемент массива
    public static void printMinAndMaxInMass(int[] mass) {
        int min = mass[0];
        int max = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
            }
            if (max < mass[i]) {
                max = mass[i];
            }
        }
        System.out.println("Минимальный элемент массива " + min);
        System.out.println("Максимальный элемент массива " + max);
    }


      // метод, определяющий есть ли в массиве место, в котором сумма левой и правой части массива равны.
    public static boolean checkBalance(int[] mass) {
        int sum1 = 0;
        int sum2;
        boolean isBalance = false;
        for (int i = 0; i < mass.length; i++) {
            sum1 = sum1 + mass[i];
            sum2=0;
            for (int j = mass.length - 1; j > i; j--) {
                sum2 = sum2 + mass[j];}
                if (sum2 == sum1) {
                    isBalance = true;
                }

        }
    return isBalance;
        }



    // метод, осуществляющий сдвиг элементов массива на n позиций
    public static void changeMass(int[] mass, int n) {
        int b;
        int c;
     if (n>0){
        while (n>0) {
              b=0;
            for (int i = 0; i < mass.length; i++) {
                c = mass[i];
                mass[i] = b;
                b = c;
            }
        n--;
        }
     }
     if (n<0){
         while (n<0) {
             b=0;
             for (int i = mass.length-1; i >= 0; i--) {
                 c = mass[i];
                 mass[i] = b;
                 b = c;
             }
             n++;
         }
     }
    }
}