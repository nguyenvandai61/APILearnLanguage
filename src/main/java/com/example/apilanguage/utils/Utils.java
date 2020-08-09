package com.example.apilanguage.utils;

import com.example.apilanguage.model.DanhNgon;
import com.example.apilanguage.model.Word;
import org.jsoup.nodes.Element;

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

    public static DanhNgon splitChamNgon(Element ele) {
//        String str = "class=\"Head\">(.*?)</span>(.*?)\"qtRandom\"><p>(.*?)</p>(.*?)\"Lit\">(.*?)</p>(.*?)\"qtRndAu\"(.*?)</p>";
        String theLoai = ele.getElementsByClass("Head").get(0).text();
        String cauViet = ele.getElementsByClass("qtRandom").get(0).text();
        String cauNgoaiNgu;
        if (ele.getElementsByClass("Lit").size()==0)
            cauNgoaiNgu = "";
        else
            cauNgoaiNgu = ele.getElementsByClass("Lit").get(0).text();
        String tacgia = ele.getElementsByClass("qtRndAu").get(0).text();
        DanhNgon newDanhNgon = new DanhNgon(theLoai, cauViet, cauNgoaiNgu, tacgia);
        return newDanhNgon;
    }
}
