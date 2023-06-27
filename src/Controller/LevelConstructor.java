package Controller;

import Model.Levels.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LevelConstructor
{
    public static String location = "src/main/java/org.example/Game.json";
    public static Level construct(int _level, int _section) throws FileNotFoundException
    {
        _level--;
        _section--; //making level and section not 0 based
        long hearts;
        long marioState;
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            hearts = (long) data.get("hearts");
            marioState = (long) data.get("marioState");
            JSONArray levels = (JSONArray) data.get("levels");
            JSONArray sections = (JSONArray) levels.get(_level);
            JSONObject currentSection = (JSONObject) sections.get(_section);
            long length = (long) currentSection.get("length");
            long time = (long) currentSection.get("time");
            JSONArray blocks = (JSONArray) currentSection.get("blocks");
            JSONArray enemies = (JSONArray) currentSection.get("enemies");
            JSONArray pipes = (JSONArray) currentSection.get("pipes");
            JSONArray items = (JSONArray) currentSection.get("items");
            JSONArray physicalObjects = (JSONArray) currentSection.get("physicalObjects");
            JSONObject spawnPipe = (JSONObject) currentSection.get("spawnPipe");

        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static int numberOfSections( int _level){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location)) {
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            JSONArray levels = (JSONArray) data.get("levels");
            JSONArray sections = (JSONArray) levels.get(_level);
            return sections.size();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}