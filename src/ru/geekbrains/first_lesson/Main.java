package ru.geekbrains.first_lesson;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '.';

    public static char[][] map;

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        char human_dot;
        char ai_dot;
        initMap();
        printMap();
        int turn = selectTurn();
        if (turn==1) {
            human_dot='X';
            ai_dot='0';
        }
        else { human_dot='0';
            ai_dot='X';
        }
            if (turn ==1 )
            {  while (true) {
                humanTurn(human_dot);
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn(ai_dot);
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            }
            if (turn ==2) {
                while (true) {
                    aiTurn(ai_dot);
                    if (isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                    humanTurn(human_dot);
                    if (isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                }

        }
        System.out.println("Игра закончена");
    }
    public static int selectTurn ()
    {
        Random rand = new Random();
        int n = rand.nextInt(2)+1;
        return n;
    }

public static void showComputerTurn (int xBlock, int yBlock, char symb) {
    map[xBlock][yBlock] = symb;
    System.out.println("Компьютер походил в точку " + xBlock + " " + yBlock);
    printMap();
    if (checkWin(symb, xBlock, yBlock)) {
        System.out.println("Победил Компьютер!");
        System.exit(0);
    }
}
    public static boolean computerIntelligence  (char symb, int x, int y) {
        int xBlock;
        int yBlock;
        int kol = 0;
        for (int i = y, j = x; i < map.length && j < map[i].length; j++, i++) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1)) {
                    if ((j + 1 < map[i].length) && (i + 1 < map.length) && (isCellValid(i + 1, j + 1))) {
                        xBlock = j + 1;
                        yBlock = i + 1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                    if ((j - DOTS_TO_WIN-2 < map[i].length) && (i - DOTS_TO_WIN-2 < map.length) && (isCellValid(i - DOTS_TO_WIN-2, j - DOTS_TO_WIN-2))) {
                        xBlock = j - DOTS_TO_WIN-2 ;
                        yBlock = i - DOTS_TO_WIN-2 ;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }

                }
            }
            kol = 0;
        }

        for (int i = y, j = x; i >= 0 && j >= 0; j--, i--) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1)) {
                    if ((j - 1 >= 0) && (i - 1 >= 0) && (isCellValid(i - 1, j - 1))) {
                        xBlock = j - 1;
                        yBlock = i - 1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                    if ((j +DOTS_TO_WIN+1 < map[i].length) && (i +DOTS_TO_WIN+1 < map.length) && (isCellValid(i + DOTS_TO_WIN+1, j+DOTS_TO_WIN+1))) {
                        xBlock = j +DOTS_TO_WIN+1;
                        yBlock = i +DOTS_TO_WIN+1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                }
            }
            kol=0;
        }
        for (int i = y, j = x; j<map[i].length; j++) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1)){
                    if((j+1<map[i].length)&&(isCellValid(j+1, i)))
                    {   xBlock = j+1;
                        yBlock = i;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                    if((j-DOTS_TO_WIN-1>=0)&&(isCellValid(j-DOTS_TO_WIN-1,i)))
                    {   xBlock = j-DOTS_TO_WIN-1;
                        yBlock = i;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                }
            }
            kol=0;
        }
        for (int i = y, j = x; i<map.length; i++) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1)) {
                    if ((i + 1 < map.length) && (isCellValid(j, i + 1))) {
                        xBlock = j;
                        yBlock = i + 1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                    if ((i -DOTS_TO_WIN-1 >=0) && (isCellValid(j, i -DOTS_TO_WIN-1))) {
                        xBlock = j;
                        yBlock = i -DOTS_TO_WIN-1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
                }

            }
            kol = 0;
        }
        for (int i = y, j = x; j>=0; j--) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1))
                {
                   if ((j-1>=0)&&(isCellValid(j-1,i)))
                   {

                    xBlock = j-1;
                    yBlock = i;
                       showComputerTurn(xBlock, yBlock, symb);
                       return true;
                }
                    if ((j+DOTS_TO_WIN+1>=0)&&(isCellValid(j+DOTS_TO_WIN+1,i)))
                    {

                        xBlock = j+DOTS_TO_WIN+1;
                        yBlock = i;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;
                    }
            }
        }
            kol=0;
        }
        for (int i = y, j = x; i>=0; i--) {
            if (map[i][j] == symb) {
                kol++;
                if ((kol == DOTS_TO_WIN - 1)) {
                    if ((i - 1 >= 0) && (isCellValid(j, i-1))) {
                        xBlock = j;
                        yBlock = i-1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;

                    }
                    if ((i +DOTS_TO_WIN+1  < map.length) && (isCellValid(j, i+DOTS_TO_WIN+1))) {
                        xBlock = j ;
                        yBlock = i+DOTS_TO_WIN+1;
                        showComputerTurn(xBlock, yBlock, symb);
                        return true;

                    }
                }
            }
            kol=0;
        }
        return false;
    }

    public static boolean checkWin(char symb, int x, int y) {
        int kol=0;
     for (int i=y, j=0; j<map[i].length; j++) {
         if (map[i][j] == symb) {
             kol++;
             if(kol>=DOTS_TO_WIN) return true;
         }
         else if (map[i][j] != symb && (j!=0)) {
             kol = 0;
             break;
         }
     }
        for (int i=0, j=x; i<map.length; i++) {
            if (map[i][j]==symb)
            {kol++;
            if (kol>=DOTS_TO_WIN) return true;}
           else if (map[i][j]!=symb&&i!=0) {
                kol=0;
                break;
            }
        }
        if (x==y) {
            for (int i=0; i< map.length; i++)
            {
                if (map[i][i]==symb) {
                    kol++;
                    if (kol >= DOTS_TO_WIN) return true;
                }
                else if (map[i][i]!=symb&&i!=0) {
                    kol=0;
                    break;
            }
            }
        }
        if (x==(map.length-y-1)) {
            for (int i=0; i<map.length; i++)
            {
                if (map[i][map.length-i-1]==symb) {
                    kol++;
                    if (kol >= DOTS_TO_WIN) return true;
                }
                else if (map[i][map.length-i-1]!=symb&&i!=map.length-1) {
                    kol=0;
                    break;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn(char dot) {
        int x, y;
        boolean isBlock = false;
       label: for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (computerIntelligence(dot, j, i)) {
                    isBlock = true;
                    break label;
                }
            }
        }
        if (!isBlock) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = dot;
            printMap();
            if (checkWin(dot, x, y)) {
                System.out.println("Победил Компьютер!");
                System.exit(0);
            }
        }
    }
    public static void humanTurn(char dot) {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = (sc.nextInt() - 1);
            y = (sc.nextInt() - 1);
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = dot;
        printMap();
        if(checkWin(dot,x,y))
        { System.out.println("Победил человек!");
        System.exit(0);}

    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
