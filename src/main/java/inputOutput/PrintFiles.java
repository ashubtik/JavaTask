package inputOutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFiles extends SimpleFileVisitor<Path> {
    private final Path baseFolder = Paths.get("e:\\Music\\Metal\\Accept\\");
    private BufferedWriter writer;

    public PrintFiles() {
        try {
            this.writer = Files.newBufferedWriter(Path.of("data/File.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        Path relative = baseFolder.relativize(dir);
        int count = relative.getNameCount();
        try {
            this.writer.write("|" + "-------".repeat(count) + dir.getFileName() + System.getProperty("line.separator"));
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
                this.writer.write("|" + "\t".repeat(count + 2) + file.getFileName() + System.getProperty("line.separator"));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }
}
