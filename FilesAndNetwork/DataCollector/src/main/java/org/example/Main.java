package org.example;

import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        ParseHtml metro = new ParseHtml();
        for (Lines line : metro.getLines()) {
            System.out.println(line);
        }

        for (Stations station : metro.getStations()) {
            System.out.println(station);
        }

        String pathMapMoscow = "data/map.json";
        String pathStationsInfo = "data/stations.json";

        JsonMoscowMap mapMoscow = new JsonMoscowMap();
        JsonStationsInfo stationsInfo = new JsonStationsInfo();

        JSONObject objMapMoscow = mapMoscow.getMainObject();
        JSONObject objStationsInfo = stationsInfo.getMainObject();

        JsonWriter.writer(objMapMoscow, pathMapMoscow);
        JsonWriter.writer(objStationsInfo, pathStationsInfo);

    }
}