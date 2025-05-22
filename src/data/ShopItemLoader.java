package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import core.Equipment;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ShopItemLoader {

    public static List<Equipment> loadShopItems(String filePath) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);
            Type listType = new TypeToken<List<Equipment>>() {}.getType();
            return gson.fromJson(reader, listType);

        } catch (Exception e) {
            System.out.println("Failed to load shop items" + e.getMessage());
            return null;
        }
    }

}
