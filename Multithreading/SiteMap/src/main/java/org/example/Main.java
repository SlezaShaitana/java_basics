package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException {
        String ROOT_SITE = "https://skillbox.ru/";

        SiteMapNode sitemapRoot = new SiteMapNode(ROOT_SITE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SiteMapNodeRecursiveAction(sitemapRoot));

        FileOutputStream stream = new FileOutputStream("data/skillbox.txt");
        String result = createSiteMap(sitemapRoot, 0);
        stream.write(result.getBytes());
        stream.flush();
        stream.close();
    }

    public static String createSiteMap(SiteMapNode node, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl());
        node.getChildren().forEach(child -> {
            result.append("\n").append(createSiteMap(child, depth + 1));
        });
        return result.toString();
    }
}