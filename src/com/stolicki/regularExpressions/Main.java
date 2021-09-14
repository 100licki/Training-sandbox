package com.stolicki.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "a string";
        System.out.println(string);
        String yourString = string.replaceAll("a", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12gfhgidfs";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12gfhabcDeeegidfs";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^abcDeeeF12gfhgidfs"));
        System.out.println(alphanumeric.matches(""));

        System.out.println(alphanumeric.replaceAll("idfs$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));

        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12gfhjgidjfs";

        System.out.println(newAlphanumeric.replaceAll("[^ej]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "x"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "x"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "x"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "x"));

        String withWhite = "A B C D E F\t\tG H I J\n";
        System.out.println(withWhite);
        System.out.println(withWhite.replaceAll("\\s", ""));
        System.out.println(withWhite.replaceAll("\t", "x"));
        System.out.println(withWhite.replaceAll("\\S", "x"));

        System.out.println(newAlphanumeric.replaceAll("\\w", "x"));
        System.out.println(withWhite.replaceAll("\\w", "x"));
        System.out.println(withWhite.replaceAll("\\W", "x"));
        System.out.println(withWhite.replaceAll("\\b", "x"));

        String thirdAlphanumericString = "abcDeeeF12gfhgidfs";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>Paragraph</p>");
        htmlText.append("<p>Another Paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }
        String h2TextGroup = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));

            String tvTest = "tstvtkt";
            String tNotVRegExp = "t(?=v)";
            Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
            Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

            count = 0;
            while(tNotVMatcher.find()) {
                count++;
                System.out.println("Occurrence: " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
            }
        }









    }
}
