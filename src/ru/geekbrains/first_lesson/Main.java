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
        int i=0;
        initMap();
        printMap();
        int turn = selectTurn();
        switch (turn){
            case 1:
            human_dot='X';
            ai_dot='0';
                while (i<1000) {
                    humanTurn(human_dot);
                    aiTurn(ai_dot,human_dot);
                    i++;
                }
                break;
            case 2:
                human_dot='0';
                ai_dot='X';
                while (i<1000) {
                    aiTurn(ai_dot,human_dot);
                    humanTurn(human_dot);
                    i++;
                }
                break;
            }

        }

    public static int selectTurn ()
    {
        Random rand = new Random();
        int n = rand.nextInt(2)+1;
        return n;
    }

    // проверка осуществляется только в том ряду/столбце/диагонали - куда игрок сделал ход
    public static boolean hasWinner(char symb, int x, int y) {
        int kol=0;
        //проверка столбца (y)
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
     //проверка строки (x)
        for (int i=0, j=x; i<map.length; i++) {
            if (map[i][j]==symb)
            {kol++;
            if (kol>=DOTS_TO_WIN) return true;}
           else if (map[i][j]!=symb&&i!=0) {
                kol=0;
                break;
            }
        }
        //проверка главной диагонали (x,y)
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
        //проверка побочной диагонали
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

    public static void aiTurn(char dot, char humandot) {
        int x, y;
        boolean isBlock = false;
        if (iscomputerII(humandot, dot)) //если ход сделал ИИ,то дальше не ходит
            isBlock = true;
        if (!isBlock) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = dot;
            printMap();
            if (isFinish(dot, x, y, 2)) System.exit(0);
        }

    }

    //компьтер блокирует группу из 3ех подряд расположенных фишек противника, либо группу 2 + 1 в столбце/ряду)
public static boolean iscomputerII(char symbolHuman, char symbolComputer) {
       return isBlockRows(symbolHuman,symbolComputer)||isBlockColumns(symbolHuman,symbolComputer);
}

// возвращает true, если заблокировал в ряду группу из 3ех/ либо 2+1
      public static boolean isBlockRows(char symbolHuman, char symbolComputer){
           int kol = 0;
    boolean isGroup2first = false;
    boolean isGroup2second = false;
    boolean isGroup3 = false;
    int kol2 = 0;
    int xBegin=0;
    int yBegin=0;
    int xEnd=0;
    int yEnd=0;
    label: for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
            if ((map[i][j] == symbolHuman)&&(kol==0)&&(!isGroup2first)) {
                kol++;
                xBegin = j;
                yBegin = i;}
            else if ((map[i][j] == symbolHuman)&&(kol!=0)) {
                kol++;
                if (kol == 2) {
                    isGroup2first = true;
                    xEnd=j;
                    yEnd=i;
                }
                if ((kol >= 3)) {
                    isGroup3 = true;
                    xEnd = j;
                    yEnd = i;
                    kol=0;
                    break label;
                }
            }
            else if ((map[i][j]!=symbolHuman)&&(isGroup2first)){
                kol=0;

            }
            else if (((isGroup2first)&&(map[i][j])==symbolHuman)&&(isCellValid(j-1,i))) {
             isGroup2second=true;
             kol2=0;
             xEnd=j;
             yEnd=i;
             break label;
            }
            else if (map[i][j]!=symbolHuman) {
                kol=0;
                kol2=0;
             }
        }

        kol=0;
        kol2=0;
}
if (isGroup3) {
    if ((xBegin-1>=0)&&(isCellValid(xBegin-1,yBegin))) {
        map[yBegin][xBegin-1]=symbolComputer;
        printMap();
        System.out.println("Компьютер походил в точку " + (xBegin) + " " + (yBegin+1));
        if (isFinish(symbolComputer, xBegin-1, yBegin, 2)) System.exit(0);
        return true;
    }
    if((xEnd+1<map.length)&&(isCellValid(xEnd+1,yEnd))){
        map[yEnd][xEnd+1]=symbolComputer;
        printMap();
        System.out.println("Компьютер походил в точку " +(xEnd + 2) + " " + (yEnd+1));
        if (isFinish(symbolComputer,  xEnd+1, yEnd, 2)) System.exit(0);
        return true;
    }
}
if ((isGroup2second)&&(xEnd-1>=0)&&(isCellValid(xEnd-1, yEnd))) {
    map[yEnd][xEnd-1]=symbolComputer;
    printMap();
    System.out.println("Компьютер походил в точку " +(xEnd) + " " + (yEnd+1));
    if (isFinish(symbolComputer, xEnd-1, yEnd, 2)) System.exit(0);
    return true;
}
return false;
}
    // возвращает true, если заблокировал в столбце группу из 3ех/ либо 2+1
public static boolean isBlockColumns(char symbolHuman, char symbolComputer){
        int kol = 0;
        boolean isGroup2first = false;
        boolean isGroup2second = false;
        boolean isGroup3 = false;

        int kol2 = 0;
        int xBegin=0;
        int yBegin=0;
        int xEnd=0;
        int yEnd=0;
        label: for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if ((map[j][i] == symbolHuman)&&(kol==0)&&(!isGroup2first)) {
                    kol++;
                    xBegin = i;
                    yBegin = j;}
                else if ((map[j][i] == symbolHuman)&&(kol!=0)) {
                    kol++;
                    if (kol == 2) {
                        isGroup2first = true;
                        xEnd=i;
                        yEnd=j;
                    }
                    if ((kol >= 3)) {
                        isGroup3 = true;
                        xEnd = i;
                        yEnd = j;
                        kol=0;
                        break label;
                    }
                }
                else if ((map[j][i]!=symbolHuman)&&(isGroup2first)){
                    kol=0;

                }
                else if (((isGroup2first)&&(map[j][i])==symbolHuman)&&(isCellValid(i,j-1))) {
                    isGroup2second=true;
                    kol2=0;
                    xEnd=i;
                    yEnd=j;
                    break label;
                }
                else if (map[j][i]!=symbolHuman) {
                    kol=0;
                    kol2=0;
                }
            }

            kol=0;
            kol2=0;
        }
        if (isGroup3) {
            if ((yBegin-1>=0)&&(isCellValid(xEnd,yBegin-1))) {
                map[yBegin-1][xEnd]=symbolComputer;
                printMap();
                System.out.println("Компьютер походил в точку " +(xEnd +1) + " " + (yBegin));
                if (isFinish(symbolComputer, xEnd, yBegin-1, 2)) System.exit(0);
                return true;
            }
            if((yEnd+1<map.length)&&(isCellValid(xEnd, yEnd+1))){
                map[yEnd+1][xEnd]=symbolComputer;
                printMap();
                System.out.println("Компьютер походил в точку " +(xEnd+1) + " " + (yEnd+2));
                if (isFinish(symbolComputer,  xEnd, yEnd+1, 2)) System.exit(0);
                return true;
            }
        }
        if ((isGroup2second)&&(yEnd-1>=0)&&(isCellValid(xEnd, yEnd-1))) {
            map[yEnd-1][xEnd]=symbolComputer;
            printMap();
            System.out.println("Компьютер походил в точку " +(xEnd + 1) + " " + (yEnd));
            if (isFinish(symbolComputer, xEnd, yEnd-1, 2)) System.exit(0);
            return true;
        }
        return false;
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
        if (isFinish(dot,x,y,1)) System.exit(0);

    }

    public static boolean isFinish (char symb, int x, int y, int person){
        if(hasWinner(symb,x,y)&&person==1)
        { System.out.println("Победил человек!");
            return true;}
        if(hasWinner(symb,x,y)&&person==2)
        { System.out.println("Победил компьютер!");
            return true;}
        if (isMapFull()) {
            System.out.println("Ничья");
          return true;
        }
        return false;
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
