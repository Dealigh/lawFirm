package com.solvd.lawFirm.manageFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class FileReader {

    public static void mainSecond(String[] args) throws IOException {
        int counter = 0, maxCounter = 0;

        String comparator = "", secondaryComparator = "";
        String[] wordChecker = new String[5];

        File sourceFile = new File("src/main/resources/climateChange.txt");
        File writer = new File("src/main/resources/newFile.txt");

        String fileString = FileUtils.readFileToString(sourceFile, "UTF-8").toUpperCase();

        fileString = fileString.replace(".", "");
        fileString = fileString.replace(",", "");
        fileString = fileString.replaceAll("[<>\\[\\],.-]", "");

        String[] arrayWord = StringUtils.split(StringUtils.join(fileString), " ");

        Set<String> theWords = Arrays.stream(arrayWord).collect(Collectors.toSet());

        for (String s : arrayWord) {
            if (s.length() <= 3) {
                s = StringUtils.remove(s, s);
            }
            counter = StringUtils.countMatches(Arrays.toString(arrayWord), s);
            if (counter > maxCounter) {
                maxCounter = counter;
            }
        }
        while (maxCounter != 0) {
            for (String s : theWords) {
                counter = StringUtils.countMatches(Arrays.toString(arrayWord), s);
                if (maxCounter == counter) {
                    FileUtils.write(writer, s + " - " + counter + "\n", (String) null, true);
                }
            }
            maxCounter--;
        }
    }
}
