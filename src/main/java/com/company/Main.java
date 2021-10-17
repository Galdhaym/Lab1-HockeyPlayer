package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.*;

public class Main {

    public static final String BACKUP_PATH = "C:\\Users\\Дима\\IdeaProjects\\Lab1-HockeyPlayer\\src\\resources\\";

    public static boolean createBackUpCopyOfFile(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "") + "_copy.txt");
        if(!Files.exists(path)) {
            return false;
        }
        Files.copy(file.toPath(), path, REPLACE_EXISTING);
        return true;
    }

    public static void restoreStateFromBackUp(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "") + "_copy.txt");
        if(!Files.exists(path)) {
            return;
        }
        Files.copy(path, file.toPath(), REPLACE_EXISTING);
    }

    public static void serializeJson(HockeyPlayer hockeyPlayer){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(hockeyPlayer);
        System.out.println(jsonObject);
        HockeyPlayer resultHockeyPlayer = gson.fromJson(jsonObject, HockeyPlayer.class);
        System.out.println(resultHockeyPlayer);
    }

    public static void main(String[] args) throws Exception {
        HockeyPlayer hockeyPlayer1 = new HockeyPlayer("Dima", 19, 5, 10);
        HockeyPlayer hockeyPlayer2 = new HockeyPlayer("Koliya", 30, 10, 0);
        boolean value;
        File file = new File("C:\\Users\\Дима\\IdeaProjects\\Lab1-HockeyPlayer\\src\\resources\\text.txt");
        file.createNewFile();
        try (ObjectSerializer objectSerializer = new ObjectSerializer(file)) {
            objectSerializer.save(hockeyPlayer1);
            value = createBackUpCopyOfFile(file);
            objectSerializer.save(hockeyPlayer2);
            HockeyPlayer hockeyPlayer1Before = (HockeyPlayer) objectSerializer.load();
            HockeyPlayer hockeyPlayer2Before = (HockeyPlayer) objectSerializer.load();
            System.out.println("До бекапа: ");
            System.out.println(hockeyPlayer1Before);
            System.out.println(hockeyPlayer2Before);
        }
        try (ObjectSerializer restoreObjectSerializer = new ObjectSerializer(file)) {
            if (value) {
                restoreStateFromBackUp(file);
            }
            HockeyPlayer hockeyPlayer1After = (HockeyPlayer) restoreObjectSerializer.load();
            System.out.println("После бекапа: ");
            System.out.println(hockeyPlayer1After);
        }
    }
}
