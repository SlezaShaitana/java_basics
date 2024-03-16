package org.example;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParsingCsv {
    private List<String> csvLines;
    @Getter
    private List<StationDate> stationsDates;

    public ParsingCsv() {
        parse();
        listFormatted();
    }

    private void parse() {
        stationsDates = new ArrayList<>();
        List<String> lines = getCsvInLines();
        for (String line : lines) {
            String[] tokens = line.split(",");
            if (tokens.length != 2) {
                System.out.println("Wrong line = " + line);
            }
            stationsDates.add(new StationDate(tokens[0], tokens[1]));
        }
    }

    private List<String> getCsvInLines() {
        List<String> lines;
        csvLines = new ArrayList<>();

        SearchFiles filesSearch = new SearchFiles();
        String[] paths = filesSearch.getCsvPath().split("\n");
        for (String path : paths) {
            try {
                lines = Files.readAllLines(Path.of(path));
                lines.remove(0);
                csvLines.addAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvLines;
    }

    private void listFormatted() {
        for (int i = 0; i < stationsDates.size(); i++) {
            String name = stationsDates.get(i).getName();
            String date = stationsDates.get(i).getDate();
            for (int j = 0; j < stationsDates.size(); j++) {
                String anotherName = stationsDates.get(j).getName();
                String anotherdate = stationsDates.get(j).getDate();
                if (name.equals(anotherName) && date.equals(anotherdate)) {
                    stationsDates.remove(j);
                }
            }
        }
    }
}
