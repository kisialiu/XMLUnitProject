package com.epam;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVParser {

    private static final Logger LOGGER = Logger
            .getLogger(CSVParser.class);

    private static String csvFile = "C:\\Users\\Vladimir\\IdeaProjects\\XMLUnitProject\\media-renditions-feed_top.csv";

    private static Pattern pattern = Pattern.compile(".*(mgid:.*)&.*");

    public static void parse() {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> list = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while((line = bufferedReader.readLine()) != null){
                if(line.contains("http")){
                    String[] mgidUrls = line.split(cvsSplitBy);
                    Matcher matcher = pattern.matcher(mgidUrls[0]);
                    matcher.find();

                    LOGGER.info("url: " + matcher.group(1));
                    list.add(matcher.group(1));
                }
            }
            //LOGGER.info("sdasfd" + list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    }


}
