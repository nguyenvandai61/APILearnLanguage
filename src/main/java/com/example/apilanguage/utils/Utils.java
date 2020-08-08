package com.example.apilanguage.utils;

import com.example.apilanguage.model.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static Word splitWord(String ele) {

        Pattern pattern = Pattern.compile("<span>(.*?)</span>(.*?)<span>(.*?)</span>");
        Matcher matcher = pattern.matcher(ele);
        if (matcher.find())
        {
            String word = matcher.group(1);
            String meaning = matcher.group(3);

            Word newWord = new Word(word, meaning);
            return newWord;
        }

        return null;
    }
}
