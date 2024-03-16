package org.example;

import lombok.Getter;

import java.io.File;
import java.util.Arrays;

public class SearchFiles {
    private final String folderPath = "stations_data";
    @Getter
    private String jsonPath;
    @Getter
    private String csvPath;

    public SearchFiles() {
        getJSONfiles(folderPath);
        getCSVFiles(folderPath);
    }

    private String getJSONfiles(String folderPath) {
        jsonPath = "";
        File folder = new File(folderPath);
        if (folder.isFile() && folder.getName().endsWith(".json")) {
            jsonPath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles();
            Arrays.stream(files).forEach(f -> jsonPath += getJSONfiles(f.getAbsolutePath()));
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return jsonPath;
    }

    private String getCSVFiles(String folderPath) {
        csvPath = "";
        File folder = new File(folderPath);
        if (folder.isFile() && folder.getName().endsWith(".csv")) {
            csvPath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles();
            Arrays.stream(files).forEach(f -> csvPath += getCSVFiles(f.getAbsolutePath()));
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return csvPath;
    }

    @Override
    public String toString() {
        return "SearchFiles{" +
                "json='" + jsonPath + '\'' +
                ", csv='" + csvPath + '\'' +
                '}';
    }
}
