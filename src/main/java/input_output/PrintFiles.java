package input_output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFiles extends SimpleFileVisitor<Path> {
    private final Path baseFolder;
    private BufferedWriter writer;

    public PrintFiles(Path baseFolder) {
        this.baseFolder = baseFolder;
        try {
            this.writer = Files.newBufferedWriter(Path.of("data/file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        Path relative = baseFolder.relativize(dir);
        int count = relative.getNameCount();
        try {
            if (dir == baseFolder) {
                this.writer.write(dir.getFileName() + System.getProperty("line.separator"));
            } else {
                this.writer.write("" + "\t".repeat(count - 1) + "|" + "---" + dir.getFileName() + System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        Path relative = baseFolder.relativize(file);
        int count = relative.getNameCount();
        if (attr.isRegularFile()) {
            try {
                this.writer.write("" + "\t".repeat(count - 1) + "|\t" + file.getFileName() + System.getProperty("line.separator"));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }
}
