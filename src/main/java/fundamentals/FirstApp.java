package fundamentals;

import java.util.Random;
import java.util.Scanner;

public class FirstApp {
    public static void main(String[] args) {

//      Task1
        System.out.println("What is your name?");
        Scanner hello = new Scanner(System.in);
        System.out.println("Hello " + hello.nextLine());

//      Task2
        System.out.println("Insert arguments");
        Scanner reverseArguments = new Scanner(System.in);
        StringBuilder toll = new StringBuilder(reverseArguments.nextLine());
        toll.reverse();
        System.out.println(toll);

//      Task3
        System.out.println("5 random integers (from 0 to 10) are:");
        Random number = new Random();
        int i;
        for (i = 0; i < 5; i++) {
//            System.out.print(number.nextInt(20) + " ");
            System.out.println(number.nextInt(10));
        }

//      Task4
        System.out.println("Insert 2 integers");
        Scanner sumAndMultiplicationOfTwoArguments = new Scanner(System.in);
        int firstArgument = sumAndMultiplicationOfTwoArguments.nextInt();
        int secondArgument = sumAndMultiplicationOfTwoArguments.nextInt();

        System.out.println("The sum of 2 integers is " + (firstArgument + secondArgument));
        System.out.println("The multiplication of 2 integers is " + (firstArgument * secondArgument));

//      Task5
        System.out.println("Insert month number");
        Scanner monthNumber = new Scanner(System.in);
        int month = monthNumber.nextInt();
        setMonth(month);
    }

    static void setMonth(int monthNumber) {
        String[] monthList = {"january", "february", "march", "april", "may", "june",
                "july", "august", "september", "october", "november", "december"};
        String month;
        try {
            month = monthList[monthNumber - 1];
            System.out.println(monthNumber + "th month is " + month);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There are only 12 months in a year");
        }
    }
}

