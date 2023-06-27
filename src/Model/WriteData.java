package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
    public static void writeData() {
        Gson gson = new Gson();
        FileWriter fileWriter = null;
        JsonWriter jsonWriter = null;
        try {
            fileWriter = new FileWriter("data.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            jsonWriter = gson.newJsonWriter(fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gson.toJson(Memory.allUsers, Memory.allUsers.getClass(), jsonWriter);
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
