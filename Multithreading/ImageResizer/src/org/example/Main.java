package org.example;

import java.io.File;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {

        String srcFolder = "C:\\Users\\Саша\\Desktop\\testResize\\src";
        String dstFolder = "C:\\Users\\Саша\\Desktop\\testResize\\dst";

        int coreCount = Runtime.getRuntime().availableProcessors();

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int part = files.length / coreCount;

        for (int i = 0; i <= coreCount - 1; i++) {
            File[] imageFiles = new File[files.length - part * i];
            System.arraycopy(files, part * i, imageFiles, 0, imageFiles.length);
            org.example.ImageResizer resizer = new org.example.ImageResizer(imageFiles, newWidth, dstFolder, start);
            resizer.start();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
