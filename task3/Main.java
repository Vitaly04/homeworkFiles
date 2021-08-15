package homework.files.task3;

import homework.files.task2.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        openZip("C://Games//savegames//zip_save.zip","C://Games//savegames" );
        System.out.println(openProgress("C://Games//savegames//save3.dat"));
    }

    private static void openZip(String pathFile, String pathOpenZip) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathFile))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();// получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(pathOpenZip + "//" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static GameProgress openProgress(String pathFile) {
        GameProgress gameProgress = null;
        // откроем входной поток для чтения файла
        try (FileInputStream  fis = new FileInputStream(pathFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // десериализуем объект и скастим его в класс
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }
}
