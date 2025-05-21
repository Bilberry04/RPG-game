import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EnemyLoader {

    public static List<Enemy> loadEnemiesFromJson(String filePath) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);
            Type enemyListType = new TypeToken<List<Enemy>>() {}.getType();
            return gson.fromJson(reader, enemyListType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
