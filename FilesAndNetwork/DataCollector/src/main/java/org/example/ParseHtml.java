package org.example;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ParseHtml {
    private String url = "https://skillbox-java.github.io/";
    private String pathToHtml = "data/metro.html";
    @Getter
    public List<Lines> lines;
    @Getter
    public List<Stations> stations;

    public ParseHtml() {
        parseHtml();
    }

    private void parseHtml() {
        lines = new ArrayList<>();
        stations = new ArrayList<>();
        File htmlFile = new File(pathToHtml);

        if (htmlFile.length() == 0) {
            getHtmlPage();
        }
        try {

            Document doc = Jsoup.parse(htmlFile);
            Elements linesInfo = doc.select("span.js-metro-line");
            for (Element element : linesInfo) {
                lines.add(new Lines(element.text(), element.attr("data-line")));
            }

            Elements stationsPerLine = doc.getElementsByClass("js-metro-stations");
            for (Element element : stationsPerLine) {
                Elements stationsInfo = element.getElementsByClass("single-station");
                for (Element station : stationsInfo) {
                    String name = station.getElementsByClass("name").text();
                    String line = element.attr("data-line");
                    Boolean hasConnection = station.select("span.t-icon-metroln").hasAttr("title");
                    stations.add(new Stations(name, line, hasConnection));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getHtmlPage() {
        try {
            Document htmlFile = Jsoup.connect(url).get();
            PrintWriter writer = new PrintWriter(pathToHtml);
            writer.write(htmlFile.outerHtml());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ParseHtml{" +
                "lines=" + lines +
                ", stations=" + stations +
                '}';
    }
}