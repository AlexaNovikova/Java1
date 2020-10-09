package ru.geekbrains.first_lesson;

import java.util.Scanner;

//* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//        * Конструктор класса должен заполнять эти поля при создании объекта;
//        * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//        * Создать массив из 5 сотрудников
//        Пример:
//        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//        persArray[1] = new Person(...);
//        ...
//        persArray[4] = new Person(...);
//
//        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

public class Main {

    public static void main(String[] args) {
        Employee[] employee =new Employee[5];
        employee[0]=new Employee("Иванов Сергей Сергеевич", 44, "инженер", 80000, "8-999-999-00-00", "email1@email.com");
        employee[1]=new Employee("Петров Василий Васильевич", 33, "водитель", 30000, "8-888-888-99-99", "email2@email.com");
        employee[2]=new Employee("Матвеев Виктор Сергеевич", 45, "программист", 130000, "8-777-777-77-77", "email3@email.com");
        employee[3]=new Employee("Сидоров Иван Иванович", 30, "системный администратор", 100000, "8-555-555-55-55", "email4@email.com");
        employee[4]=new Employee("Ларионов Тимофей Тимофеевич", 41, "директор", 180000, "8-333-333-33-33", "email5@email.com");
        for (int i=0; i< employee.length; i++){
            if (employee[i].age>=40) employee[i].printInfo();
        }
        System.out.println();
    }
}

