package homework.files.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] directoryNames = {"C://Games//src", "C://Games//res", "C://Games//savegames", "C://Games//temp",
                "C://Games//src//main", "C://Games//src//test", "C://Games//res//drawables",
                "C://Games//res//vectors", "C://Games//res//icons"};
        String[] fileNames = {"C://Games//src//main//Main.java", "C://Games//src//main//Utils.java",
                "C://Games//temp//temp.txt"};
        String[] isCreateDirs = new String[directoryNames.length];
        String[] isCreateFiles = new String[fileNames.length];

        for (int i = 0; i < directoryNames.length; i++) {
            isCreateDirs[i] = createDirectory(directoryNames[i]);
        }
        for (int i = 0; i < fileNames.length; i++) {
            isCreateFiles[i] = createFile(fileNames[i]);
        }
        for (String value : isCreateDirs) {
            logFile(value);
        }
        for (String value : isCreateFiles) {
            logFile(value);
        }
    }

    private static String createDirectory(String pathName) {
        File dir = new File(pathName);
        String message;
        if (dir.mkdir()) {
            message = "Директория " + dir.getName() + " создана в " + dir.getAbsolutePath() + "\n";
        } else {
            message = "Директория " + dir.getName() + " не создана" + "\n";
        }
        return message;
    }

    private static String createFile(String pathName) {
        File file = new File(pathName);
        String message;
        try {
            if (file.createNewFile())
            message = "Файл " +  file.getName() + " был создан в " + file.getAbsolutePath() + "\n";
            else message = "Файл " +  file.getName() + " не создан " + "\n";
        } catch (IOException ex) {
            message = ex.getMessage() + "\n";
        }
        return message;
    }

    private static void logFile(String message) {
        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", true)) {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
