package ru.geekbrains.first_lesson;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public int getFood(){
        return food;
    }
    public void decreaseFood(int n) {
       while (food>0&&n!=0)
       {
           n--;
           food--;
       }
    }
    public void addFood (int n){
        food+=n;
    }
    public void info() {
        System.out.println("Количество еды: " + food);
    }
}
