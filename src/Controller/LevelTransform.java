package Controller;

import Model.Levels.Level;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.table.TableRowSorter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LevelTransform
{
    public static String location = "AP_Project/src/Config/"; //TODO : FIX LOCATION EVERYTIME
    public static void ChangeLevelToJson(Level level,User user) throws IOException {
        JsonParser jsonParser = new JsonParser();
        try (FileReader reader = new FileReader(location)) {
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            data.replace("hearts",level.getHearts());
            data.replace("marioState",level.getMarioState());

            JSONArray levels = (JSONArray) data.get("levels");
            JSONObject sectionsData = (JSONObject) levels.get(level.getLevelNumber()-1);
            JSONArray sections = (JSONArray) sectionsData.get("sections");
            JSONObject currentSection = (JSONObject) sections.get(level.getSectionNumber()-1);

            reader.close();

            try (FileWriter file = new FileWriter(location))
            {
                file.write(data.toJSONString());
                file.flush();
                file.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}