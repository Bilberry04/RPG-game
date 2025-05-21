import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ItemLoader {

    public static List<Equipment> loadItemsFromJson(String filepath) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filepath);
            Type itemListType = new TypeToken<List<Equipment>>() {}.getType();
            return gson.fromJson(reader, itemListType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
