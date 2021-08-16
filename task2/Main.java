package homework.files.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(50, 2, 3, 70);
        GameProgress gameProgress2 = new GameProgress(70, 4, 2, 200);
        GameProgress gameProgress3 = new GameProgress(80, 1, 7, 400);
        saveGame("C://Games//savegames//save1.dat", gameProgress1);
        saveGame("C://Games//savegames//save2.dat", gameProgress2);
        saveGame("C://Games//savegames//save3.dat", gameProgress3);
        ArrayList<String> list = new ArrayList<>();
        list.add("C://Games//savegames//save1.dat");
        list.add("C://Games//savegames//save2.dat");
        list.add("C://Games//savegames//save3.dat");
        zipFiles("C://Games//savegames//zip_save.zip", list);
    }

    private static void saveGame(String pathName, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(pathName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void zipFiles(String pathName, ArrayList<String> list) {
        int i = 0;
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathName));

                for (String value : list) {
                    i++;
                    FileInputStream fis = new FileInputStream(value);
                    ZipEntry entry = new ZipEntry("save" + i +".dat");
                    zout.putNextEntry(entry);
                    // считываем содержимое файла в массив
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    // добавляем содержимое к архиву
                    zout.write(buffer);
                    // закрываем текущую запись для новой записи
                    zout.closeEntry();
                    fis.close();
                }
                zout.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (String value: list) {
            File file = new File(value);
            if (file.delete())
                System.out.println("файл " + file.getName() + " удален");
        }

    }
}


