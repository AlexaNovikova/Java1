package ru.geekbrains.first_lesson;

public class Employee {
    public int age;
    public String FIO;
    public String position;
    public String eMail;
    public String telephoneNumber;
    public int salary;

    Employee(String FIO, int age, String position, int salary, String telephoneNumber, String eMail) {
        this.age=age;
        this.FIO=FIO;
        this.position=position;
        this.salary=salary;
        this.telephoneNumber=telephoneNumber;
        this.eMail=eMail;
    }
    void printInfo (){
        System.out.println("ФИО: "+ this.FIO+ ", возраст: "+ this.age + "," +
                " должность: " +this.position+ ", зарплата: "+ this.salary+ ", " +
                "телефон: "+ this.telephoneNumber+ ", почта: "+ this.eMail+ ".");
    }
}
