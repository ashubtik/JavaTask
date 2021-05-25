package IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

                long numberOfDirs = 0;
                try (FileReader reader = new FileReader(element);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    numberOfDirs = bufferedReader.lines()
                            .filter(line -> line.startsWith("|-----["))
                            .count();
                    System.out.println(numberOfDirs + " dirs");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                double numberOfFiles = 0;
                try (FileReader reader = new FileReader(element);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    numberOfFiles = bufferedReader.lines()
                            .filter(line -> line.endsWith(".mp3"))
                            .count();
                    int result = (int) Math.round(numberOfFiles);
                    System.out.println(result + " files");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (FileReader reader = new FileReader(element);
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    double averageLength = bufferedReader.lines()
                            .filter(line -> line.endsWith(".mp3"))
                            .mapToInt(String::length)
                            .average()
                            .getAsDouble();
                    System.out.println("Average file length = " + averageLength);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                double averageNumberOfFiles = numberOfFiles / numberOfDirs;
                System.out.format("%.3f", averageNumberOfFiles);
            }
            }
        }
    }




