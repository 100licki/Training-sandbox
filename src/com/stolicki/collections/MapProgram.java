package com.stolicki.collections;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Aaa", "aa aa aaa aa");
        System.out.println(languages.put("Bbb", "bb bb bbb bb"));
        languages.put("Ccc", "cc cc ccc cc");
//
//        System.out.println(languages.get("Aaa"));
//        languages.put("Aaa", "AAAAAAAAAAA");
//        System.out.println(languages.get("Aaa"));
        System.out.println(languages.get("Bbb"));
        System.out.println("=========");



        for(String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
