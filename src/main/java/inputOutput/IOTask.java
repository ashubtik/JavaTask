package inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IOTask {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (file.exists() && file.isDirectory()) {
            Path files = Paths.get(args[0]);
            PrintFiles pf = new PrintFiles();
            try {
                Files.walkFileTree(files, pf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.exists() && file.isFile()) {
            List<String> lines;
            try (FileReader reader = new FileReader(args[0]);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                lines = bufferedReader.lines().collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            double numberOfDirs = lines.stream()
                    .filter(line -> line.startsWith("|-"))
                    .count();
            System.out.println(numberOfDirs + " dirs");

            double numberOfFiles = lines.stream()
                    .filter(line -> line.startsWith("|\t"))
                    .count();
            System.out.println(numberOfFiles + " files");

            double averageLength = lines.stream()
                    .filter(line -> line.startsWith("|\t"))
                    .mapToInt(String::length)
                    .average()
                    .getAsDouble();
            System.out.println("Average file name length = " + averageLength);

            double averageNumberOfFiles = numberOfFiles / numberOfDirs;
            System.out.println("Average number of files in dir = " + averageNumberOfFiles);
        }
    }
}





