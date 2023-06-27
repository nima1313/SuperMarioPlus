package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReadData {
    public static void readData() {
        Gson gson = new Gson();
        FileReader fileReader = null;
        JsonReader jsonReader = null;
        try {
            fileReader = new FileReader("data.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jsonReader = gson.newJsonReader(fileReader);
        TypeToken<ArrayList<User>> typeToken = new TypeToken<>(){};
        Memory.allUsers = gson.fromJson(jsonReader, (Type) typeToken);
    }
}
