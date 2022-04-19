package com.solvd.lawFirm.manageFile;

import com.solvd.lawFirm.person.Judge;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class fileReader {

    public static void main(String[] args) throws IOException {
        int counter = 0, maxCounter = 0;

        String comparator = "", secondaryComparator = "";
        String[] wordChecker = new String[5];

        File sourceFile = new File("src/main/resources/climateChange.txt");
        FileWriter writer = new FileWriter("src/main/resources/newFile.txt");

        String fileString = FileUtils.readFileToString(sourceFile);
        String[] arrayWord = StringUtils.split(StringUtils.join(fileString), " ");
        List<String> words = Arrays.asList(arrayWord);

        for (String s : words) {
            if (s.length() <= 4) {
                s = StringUtils.remove(s, s);
            }

            counter = StringUtils.countMatches(Arrays.toString(arrayWord), s);
            if (counter > maxCounter) {
                maxCounter = counter;
            }

        }

        while (maxCounter != 0) {

            for (String s : words) {
                counter = StringUtils.countMatches(Arrays.toString(arrayWord), s);

                if (!StringUtils.isAlphanumeric(s)) {
                    s = s.replaceAll("[<>\\[\\],.-]", "");
                }
                if (maxCounter == counter && !(comparator.equals(s)) && !(secondaryComparator.equals(s))) {
                    writer.write(s + " - " + counter + "\n");
                    secondaryComparator = comparator;
                    comparator = s;
                }
            }
            maxCounter--;
        }

    }

}
