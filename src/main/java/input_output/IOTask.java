package input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOTask {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (file.exists() && file.isDirectory()) {
            Path files = Paths.get(args[0]);
            PrintFiles pf = new PrintFiles(files);
            try {
                Files.walkFileTree(files, pf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.exists() && file.isFile()) {
            String line;
            int dirs = 0;
            int files = 0;
            int totalFileNameLength = 0;
            double averageNumberOfFiles;

            try (FileReader reader = new FileReader(args[0]);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains("|-")) {
                        dirs++;
                    } else if (line.contains("|\t")) {
                        files++;
                        String eachLine = line.split("\\|")[1];
                        totalFileNameLength += eachLine.trim().length();
                    }
                }
                System.out.println(dirs + " dirs");
                System.out.println(files + " files");
                if (files == 0) {
                    throw new ArithmeticException();
                } else {
                    System.out.format("Average file name length = " + "%.2f", (double) totalFileNameLength / files);
                }
                if (dirs == 0) {
                    averageNumberOfFiles = files;
                } else {
                    averageNumberOfFiles = (double) files / dirs;
                }
                System.out.format("\nAverage number of files in dir = " + "%.2f", averageNumberOfFiles);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ArithmeticException e) {
                System.out.println("Division by zero, there are no files in baseFolder");
                e.printStackTrace();
            }
        }
    }
}






