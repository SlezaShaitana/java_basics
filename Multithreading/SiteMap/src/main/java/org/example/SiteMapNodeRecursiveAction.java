package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class SiteMapNodeRecursiveAction extends RecursiveAction {
    private SiteMapNode node;

    public SiteMapNodeRecursiveAction(SiteMapNode node) {
        this.node = node;
    }

    @Override
    protected void compute() {
        try {
            sleep(600);
            Connection connection = Jsoup.connect(node.getUrl()).userAgent("Chrome/102.0.5005.65")
                    .timeout(10000)
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .followRedirects(false)
                    .referrer(node.getUrl());

            Document page = connection.get();
            Elements elements = page.select("a");
            for (Element e : elements) {
                String childUrl = e.absUrl("href");
                if (isCorrectUrl(childUrl)) {
                    childUrl = stripParams(childUrl);
                    System.out.println(childUrl);
                    node.addChild(new SiteMapNode(childUrl));
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

        List<SiteMapNodeRecursiveAction> taskList = new ArrayList<>();
        for (SiteMapNode child : node.getChildren()) {
            SiteMapNodeRecursiveAction task = new SiteMapNodeRecursiveAction(child);
            task.fork();
            taskList.add(task);
        }
        for (SiteMapNodeRecursiveAction task : taskList) {
            task.join();
        }
    }

    private String stripParams(String url) {
        return url.replaceAll("\\?.+", "");
    }

    private boolean isCorrectUrl(String url) {
        Pattern patternRoot = Pattern.compile("^" + node.getUrl());
        Pattern patternNotFile = Pattern.compile("([^\\s]+(\\.(?i)(jpg|jpeg|webp" +
                "|doc|png|gif|bmp|pdf))$)");
        Pattern patternNotAnchor = Pattern.compile("#([\\w\\-]+)?$");

        return patternRoot.matcher(url).lookingAt()
                && !patternNotFile.matcher(url).find()
                && !patternNotAnchor.matcher(url).find();
    }
}
