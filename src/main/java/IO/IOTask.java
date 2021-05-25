package IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IOTask {
    public static void main(String[] args) {
        for (String element : args) {
            File file = new File(element);
            if (file.exists() && file.isDirectory()) {
                Path files = Paths.get(element);
                PrintFiles pf = new PrintFiles();

                try {
                    PrintStream out = new PrintStream(new FileOutputStream("data/File.txt"));
                    System.setOut(out);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Files.walkFileTree(files, pf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.exists() && file.isFile()) {

                try (FileReader reader = new FileReader(element);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    long numberOfDirs = bufferedReader.lines()
                            .filter(line -> line.startsWith("|-----["))
                            .count();
                    System.out.println(numberOfDirs + " dirs");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (FileReader reader = new FileReader(element);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    long numberOfFiles = bufferedReader.lines()
                            .filter(line -> line.endsWith(".mp3"))
                            .count();
                    System.out.println(numberOfFiles + " files");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scanner scanner = new Scanner(element);
                String line = scanner.nextLine();

                }
            }
        }
    }




