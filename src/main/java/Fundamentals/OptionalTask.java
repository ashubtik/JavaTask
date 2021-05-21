package Fundamentals;

import java.util.Scanner;

public class OptionalTask {
    public static void main(String[] args) {
//      Task1. Ввести n чисел с консоли. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String longNumber = "", shortNumber = line;
        for (String number : line.split(" ")) {
            if (number.length() > longNumber.length()) longNumber = number;
            if (number.length() < shortNumber.length()) shortNumber = number;
        }
        System.out.println("The longest number is " + longNumber + ", its length is " + longNumber.length());
        System.out.println("The shortest number is " + shortNumber + ", its length is " + shortNumber.length());
    }
}

