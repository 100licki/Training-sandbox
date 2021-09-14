package com.stolicki.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {

    public static void main(String[] args) {

        String string1 = "I want a bike.";
        String string2 = "I want a ball.";
        System.out.println(string1.matches(".{14}"));
        System.out.println(string2.matches(".*"));
        System.out.println(string1.matches("I want a \\w+."));
        String regExp = "I want a (bike|ball).";
        System.out.println(string2.matches(regExp));

        System.out.println("______________");

        Pattern pattern = Pattern.compile("I want a \\w+.");
        Matcher matcher = pattern.matcher(string1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(string2);
        System.out.println(matcher.matches());

        String string3 = "Replace all blanks with underscores.";

        System.out.println(string3.replaceAll(" ", "_"));
        System.out.println(string3.replaceAll("\\s", "_"));

        System.out.println("____________");

        String string4 = "aaabccccccccdddefffg";
        System.out.println(string4.matches("a{3}bc{8}d{3}ef{3}g"));
        System.out.println(string4.matches("[abcdefg]+"));
        System.out.println(string4.matches("[a-g]+"));

        System.out.println(string4.matches("^a{3}bc{8}d{3}ef{3}g$"));

        System.out.println("_____________");

        String string5 = "AaasdEz.091231231";

        String regExp2 = "^[A-z]+\\.[0-9]+$";

        System.out.println(string5.matches(regExp2));

        String string6 = "abcd.135uvqz.7tkzik.999";

        String regExp3 = "[0-9]+";

        Pattern pattern1 = Pattern.compile(regExp3);
        Matcher matcher1 = pattern1.matcher(string6);

        while (matcher1.find()) {
            System.out.println("Occurrence: " + matcher1.group(0));
        }

        System.out.println("___________");


        String string7 = "abcd.135\tuvqz.7\ttkzik.999\n";

        String regExp4 = "[0-9]+";

        Pattern pattern2 = Pattern.compile(regExp4);
        Matcher matcher2 = pattern2.matcher(string7);

        while (matcher2.find()) {
            System.out.println("Occurrence: " + matcher2.group(0));

        }

        System.out.println("________");

        String string8 = "abcd.135uvqz.7tkzik.999";

        String regExp5 = "[0-9]+";

        Pattern pattern3 = Pattern.compile(regExp3);
        Matcher matcher3 = pattern3.matcher(string6);

        while (matcher3.find()) {
            System.out.println("Occurrence: " + matcher3.start() + " to " + (matcher3.end() - 1));
        }

        System.out.println("________");


        String string9 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {X, 2}, {2,1}";
        String regExp6 = "(\\{)(\\d+, *\\d+?)(})";

        Pattern pattern4 = Pattern.compile(regExp6);
        Matcher matcher4 = pattern4.matcher(string9);

        while (matcher4.find()) {
            System.out.println("Occurrence: " + matcher4.group(2));
        }

        String string10 = "11111-1111";
        String regExp7 = "^[0-9]{5}-[0-9]{4}$|^[0-9]{5}$";
        String regExp7Optional = "^\\d{5}(-\\d{4})?$";
        Pattern pattern5 = Pattern.compile(regExp7);
        Matcher matcher5 = pattern5.matcher(string10);
        System.out.println(matcher5.matches());

        Pattern pattern6 = Pattern.compile(regExp7Optional);
        Matcher matcher6 = pattern6.matcher(string10);
        System.out.println(matcher6.matches());

    }
}
