package IO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintFiles extends SimpleFileVisitor<Path>{

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.format("|-----" + dir.getFileName() + System.getProperty("line.separator"));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attr) {
            if (attr.isSymbolicLink()) {
                System.out.format(file.getFileName() + System.getProperty("line.separator"));
            } else if (attr.isRegularFile()) {
                System.out.format("|     " + file.getFileName() + System.getProperty("line.separator"));
            } else {
                System.out.format(file.getFileName() + System.getProperty("line.separator"));
            }
            return FileVisitResult.CONTINUE;
        }



    }
