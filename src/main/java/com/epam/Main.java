package com.epam;


import org.apache.log4j.Logger;
import com.epam.CSVParser;

public class Main {

    private static final Logger LOGGER = Logger
            .getLogger(Main.class);

    public static void main(String[] args){
        LOGGER.info("It works!");
        /*StringBuilder stringBuilder =*/ CSVParser.parse();

    }

}

