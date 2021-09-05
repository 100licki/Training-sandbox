package com.stolicki.io.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path path) throws IOException {
                return Files.isRegularFile(path);
            }
        };
//        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);
//        DirectoryStream.Filter<Path> filter = Files::isRegularFile;

//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");


        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("Volume name/Drive letter = `" + store);
            System.out.println(store.name());
        }
        System.out.println("*************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println(path);
        }

        System.out.println("Walking Tree for Dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree", File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Copy Dir2 to Dir4/Dir2Copy");
        Path copyPath = FileSystems.getDefault().getPath("FileTree", File.separator + "Dir4" + File.separator + "Dir2Copy");

        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path,copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File("\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("\\Examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("Print Dir2 contents using list()");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i=0; i<dir2Contents.length; i++) {
            System.out.println("i = " + i + ": " + dir2Contents[i]);
        }

        System.out.println("print Dir2 contents using listFiles()");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i<dir2Files.length; i++) {
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }

//        try {
//
//            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
//            long size = Files.size(filePath);
//            System.out.println("Size = " + size);
//            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));
//
//            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
//            System.out.println("size =" + attributes.size());
//            System.out.println("Last modified = " + attributes.lastModifiedTime());
//            System.out.println("Created = " + attributes.creationTime());
//            System.out.println("Is regular file = " + attributes.isRegularFile());

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5");
//            Files.createDirectories(dirToCreate);

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.deleteIfExists(fileToDelete);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove, destination);
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//        Path path = FileSystems.getDefault().getPath("src", "com", "stolicki", "io", "filesystem", "WorkingDirectoryFile.txt");
//        printFile(path);
////        Path filePath = FileSystems.getDefault().getPath("src", "com", "stolicki", "io", "filesystem", "files","file1.txt");
//        Path filePath = Paths.get( ".", "src", "com", "stolicki", "io", "filesystem", "files","file1.txt");
//        printFile(filePath);
//        filePath = Paths.get("C:\\Users\\karol\\..Intellij Projects\\zadania_rekrutacyjne_sandbox\\OutThere.txt");
//        printFile(filePath);
//
//
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath("aaa.txt");
//        System.out.println(path2.toAbsolutePath());
//
//        Path path3 = Paths.get("Z:\\aaaa\\eeee\\dog.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("src", "com", "stolicki", "io", "filesystem", "files");
//        System.out.println("Exixts = " + Files.exists(filePath));
//
//        System.out.println("Exists = " + Files.exists(path3));
//    }
//
//    private static void printFile(Path path) {
//        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
