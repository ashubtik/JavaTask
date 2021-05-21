package Collections.OptionalTask;

import java.io.*;
import java.util.*;

public class CollectionsOptionalTask {
    public static void main(String[] args) throws FileNotFoundException {
//          Task1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        Stack<String> stack = new Stack<>();
        try (Scanner scanner = new Scanner(new File("data/input.txt"));
             FileWriter writer = new FileWriter("data/output.txt")) {

            while (scanner.hasNextLine()) {
                stack.push(scanner.nextLine());
            }
            while (!stack.isEmpty()) writer.write(stack.pop() + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//          Task6. Ввести строки из файла, записать в список ArrayList.
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("data/output.txt"));

        while (scanner.hasNext()) {
            arrayList.add(scanner.nextLine());
        }
        scanner.close();
        Collections.sort(arrayList); //Task6. Выполнить сортировку строк, используя метод sort() из класса Collections.
        arrayList.sort((o1, o2) -> -(o1.length() - o2.length())); //Task4. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

        for (String string : arrayList) {
            System.out.println(string);
        }
    }
}
