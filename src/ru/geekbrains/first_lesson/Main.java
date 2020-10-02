package ru.geekbrains.first_lesson;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.SplittableRandom;

/* Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
*/
public class Main {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int a = random.nextInt(25);
        String guessedWord = words[a];
        char [] result = {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'};
        System.out.println("Игра угадай слово");
        printWords(words);
        boolean isWinner = false;
        while (!isWinner) {
            int n=0;
            Scanner snanner = new Scanner(System.in);
            System.out.println("Введите слово");
            String inputWord = snanner.nextLine();
            if (guessWord(inputWord, guessedWord, result))
            { isWinner = true;
                System.out.println("Вы угадали!");
            }

            else {
                System.out.println("Вы не угадали");
                printResult(result);
                System.out.println("Повторите ввод");
            }
        }
    }

    // метод, возвращает true если введенная буква ( из слова, введенного пользователем) есть в загаданном слове в той же позиции
    public static boolean hasLetter ( char inputLetter, String word, char[] result, int letterPosition)
    {

            if (word.charAt(letterPosition) == inputLetter ) {
                result[letterPosition]=inputLetter;
                return true;

        }
        return false;
    }

    // метод возвращает true, если все буквы введенного слова совпадают с загаданным словом
    public static boolean guessWord (String inputWord, String guessedWord, char[] result) {
        int n = 0;
        int wordsLength = (inputWord.length()>guessedWord.length())?guessedWord.length():inputWord.length();
        for (int i = 0; i < wordsLength; i++) {
            char inputLetter = inputWord.charAt(i);
            if (hasLetter(inputLetter, guessedWord, result, i )) {
                n++;
            }
        }
        if (n == guessedWord.length()) {
            return true;
        }
   return false;
    }

    public static void printResult (char [] mass) {
        for (int i=0; i< mass.length; i++) {
            System.out.print(mass[i]);
        }
        System.out.println();
    }
    public static void printWords (String[] words) {
        for (int i=0; i< words.length; i++) {
            String word = words[i];
            System.out.print(word+ " ");
        }
        System.out.println();
    }

}

