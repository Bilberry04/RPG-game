package data;

import com.google.gson.Gson;
import core.Hero;

import java.io.FileReader;
import java.io.FileWriter;

public class HeroStorage {

    public static void saveHero(Hero hero, String filename) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(filename);
            gson.toJson(hero, writer);
            writer.close();
            System.out.println("core.Hero Saved to " + filename);
        } catch (Exception e) {
            System.out.println("Failed to save core.Hero: " + e.getMessage());
        }
    }

    public static Hero loadHero(String filename) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filename);
            Hero hero = gson.fromJson(reader, Hero.class);
            reader.close();
            System.out.println("core.Hero loaded from " + filename);
            return hero;
        } catch (Exception e) {
            System.out.println("Failed to load core.Hero: " + e.getMessage());
            return null;
        }
    }

}
