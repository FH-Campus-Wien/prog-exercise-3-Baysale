package at.ac.fhcampuswien;

import java.util.*;
import java.util.stream.LongStream;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int daysInMonth, int startDay)   {
        //System.out.print(" ");

        if(startDay != 1) {
            for(int i = 1; i < startDay; i++) {
                System.out.print("   ");
            }
        }

        for(int day = 1; day <= daysInMonth; day++, startDay++) {
            if(day<=9) {
                System.out.print(" " + day + " ");
            } else {
                System.out.print("" + day + " ");
            }
            if(startDay%7==0) {
                System.out.println();
            }
        }
        startDay--;
        if(startDay%7!=0) {
            System.out.println();
        }
    }

    public static long[] lcg(long seed) {
        long m = (long) Math.pow(2, 31);
        long  a = 1103515245;
        long c = 12345;

        long[] array = new long[11];
        array[0]  = seed;

        LongStream.range(1,11).forEach(val -> array[(int) val] = ((a*array[(int)val-1])+c)%m);
        return Arrays.copyOfRange(array, 1, array.length);
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i < 10; i++) {
            System.out.print("Guess number " + i + ": ");
            int guess = scanner.nextInt();
            if(guess > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if(guess < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("You won wisenheimer!");
                return;
            }
        }
        System.out.println("Guess number 10: You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(99)+2;
    }

    public static boolean swapArrays(int[] firArray, int[] secArray) {
        if(firArray.length != secArray.length) {
            return false;
        }

        for(int i = 0; i < firArray.length; i++) {
            firArray[i] = firArray[i] + secArray[i]; //x + y = k -> (1 + 5) = 6
            secArray[i] = firArray[i] - secArray[i]; //k - y = x -> (6 - 5) = 1
            firArray[i] = firArray[i] - secArray[i]; //k - x = y -> (6 - 1) = 5
        }
        return true;
    }

    public static String camelCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] words = string.toCharArray();
        boolean upper = false;
        for(int i = 0; i < words.length; i++) {
            if(!upper) {
                words[i] = Character.toLowerCase(words[i]);
            }
            upper = false;
            if(Character.toUpperCase(words[i]) >= 'A' && Character.toUpperCase(words[i]) <= 'Z') {
                if(i==0) {
                    words[i] = Character.toUpperCase(words[i]);
                }
                stringBuilder.append(words[i]);
            }
            if(words[i] == ' ') {
                words[i+1] = Character.toUpperCase(words[i + 1]);
                upper = true;
            }
        }
        string = stringBuilder.toString().replace(" ", "");
        return string;
    }

    public static int checkDigit(int[] intArr) {
        int sum = 0;
        for(int i = 0; i <  intArr.length; i++) {
            sum += ((intArr[i]) *(i+2));
        }
        int rest = sum % 11;
        int diff = 11 - rest;

        switch(diff) {
            case 10: return 0;
            case 11: return 5;
            default: return diff;
        }
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        oneMonthCalendar(31, 4);
        guessingGame(randomNumberBetweenOneAndHundred());
    }
}