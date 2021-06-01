package fundamentals;

import java.util.Scanner;

public class OptionalTaskTwo {
    public static void main(String[] args) {
//      Task2. Ввести n чисел с консоли. Вывести числа в порядке возрастания (убывания) значений их длины.
        System.out.println("Insert 5 integers");
        String[] array = new String[5];
        Scanner arrayScanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            array[i] = arrayScanner.next();
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (String s : array) {
            System.out.println(s);
        }
    }
}
