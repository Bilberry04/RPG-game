package core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

public class HeroStorage {

    private static final String FILE_PATH = "src/json/hero.json";

    public static void saveHero(Hero hero) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            gson.toJson(hero, writer);
            writer.flush();
            System.out.println("Hero Saved to " + FILE_PATH);
            System.out.println("Saving JSON:");
            System.out.println(gson.toJson(hero));
        } catch (Exception e) {
            System.out.println("Failed to save core.Hero: " + e.getMessage());
        }
    }

    public static Hero loadHero() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Hero hero = gson.fromJson(reader, Hero.class);
            System.out.println("Hero loaded from " + FILE_PATH);
            return hero;
        } catch (Exception e) {
            System.out.println("Failed to load core.Hero: " + e.getMessage());
            return null;
        }
    }

}
