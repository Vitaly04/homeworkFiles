package homework.files.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder isCreateDir = createDirectory("C://Games//src");
        StringBuilder isCreateDir1 = createDirectory("C://Games//res");
        StringBuilder isCreateDir2 = createDirectory("C://Games//savegames");
        StringBuilder isCreateDir3 = createDirectory("C://Games//temp");
        StringBuilder isCreateDir4 = createDirectory("C://Games//src//main");
        StringBuilder isCreateDir5 = createDirectory("C://Games//src//test");
        StringBuilder isCreateFile = createFile("C://Games//src//main//Main.java");
        StringBuilder isCreateFile1 = createFile("C://Games//src//main//Utils.java");
        StringBuilder isCreateDir6 = createDirectory("C://Games//res//drawables");
        StringBuilder isCreateDir7 = createDirectory("C://Games//res//vectors");
        StringBuilder isCreateDir8 = createDirectory("C://Games//res//icons");
        StringBuilder isCreateFile3 = createFile("C://Games//temp//temp.txt");
        logFile(isCreateDir);
        logFile(isCreateDir1);
        logFile(isCreateDir2);
        logFile(isCreateDir3);
        logFile(isCreateDir4);
        logFile(isCreateDir5);
        logFile(isCreateFile);
        logFile(isCreateFile1);
        logFile(isCreateDir6);
        logFile(isCreateDir7);
        logFile(isCreateDir8);
        logFile(isCreateFile3);
    }

    private static StringBuilder createDirectory(String pathName) {
        File dir = new File(pathName);
        StringBuilder sb = new StringBuilder();
        if (dir.mkdir()) {
            sb.append("Директория " + dir.getName() + " создана в " + dir.getAbsolutePath());
            sb.append("\n");
        } else {
            sb.append("Директория " + dir.getName() + " не создана");
            sb.append("\n");
        }
        return sb;
    }

    private static StringBuilder createFile(String pathName) {
        File file = new File(pathName);
        StringBuilder sb = new StringBuilder();
        try {
            if (file.createNewFile())
            sb.append("Файл " +  file.getName() + " был создан в " + file.getAbsolutePath());
            sb.append("\n");
        } catch (IOException ex) {
            sb.append("Файл " +  file.getName() + " не создан " + ex.getMessage());
            sb.append("\n");
        }
        return sb;
    }

    private static void logFile(StringBuilder sb) {
        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
