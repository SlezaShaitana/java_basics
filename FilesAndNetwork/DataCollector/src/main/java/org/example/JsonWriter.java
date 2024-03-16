package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static void writer(JSONObject object, String path) {
        try {
            FileWriter file = new FileWriter(path);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, file);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
