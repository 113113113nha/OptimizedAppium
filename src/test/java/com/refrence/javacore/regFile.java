package com.refrence.javacore;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regFile {

    public static void main(String[] args) throws IOException {

        // 1- Read file Normal
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        File inputFile = new File(currentDir + "/a/regex_normail.txt");

        InputStream inputStream = new FileInputStream(inputFile);
        String fileString = IOUtils.toString(inputStream);
        System.out.println(fileString);
        System.out.println(fileString.length());

        int countConsonat = 0;
//        Pattern patternConsonant = Pattern.compile("([a-zA-Z&&[^aAoOiIuUeE]])"); //consonant
//        Pattern patternConsonant = Pattern.compile("([\\s\\S])"); // All character with whitespace
//        Pattern patternConsonant = Pattern.compile("([\\S])"); // All character without whitespace

        Pattern patternConsonant = Pattern.compile("([\\w])"); // Word

        Matcher matcherConsonant = patternConsonant.matcher(fileString);
        while (matcherConsonant.find()) {
            countConsonat++;
        }
        System.out.println(countConsonat);

        // 2- Read file Unicode
        File inputUFile = new File(currentDir + "/a/text_regex.txt");
        System.out.println(inputUFile.getAbsolutePath());
        Reader in = new InputStreamReader(new FileInputStream(currentDir + "/a/text_regex.txt"), "UTF-16");
        String str = IOUtils.toString(in);
        in.close();

        System.out.println(str);
        int countR = 0;
        Matcher countReg = Pattern.compile("([\\w])").matcher(str);
        while (countReg.find()) {
            countR++;
        }
        System.out.println(countR);
    }
}
