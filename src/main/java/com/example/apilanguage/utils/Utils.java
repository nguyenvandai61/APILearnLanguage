package com.example.apilanguage.utils;

import com.example.apilanguage.model.DanhNgon;
import com.example.apilanguage.model.Word;
import org.jsoup.nodes.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static void main(String[] args) {
//        String str = "<li><p class=\"text-center font-18\"><b><span>mountings</span></b></p>\n" +
//                " <section>\n" +
//                "  <h3><span><span>noun</span></span></h3>\n" +
//                "  <div>\n" +
//                "   <div>\n" +
//                "    <span>the act of a person or thing that mounts. </span>\n" +
//                "   </div>\n" +
//                "   <div>\n" +
//                "    <span>something that serves as a mount, support, setting, or the like: <span>a new mounting for an heirloom jewel.</span></span>\n" +
//                "   </div>\n" +
//                "  </div>\n" +
//                " </section></li>";
//        splitWord(str);
    }
    public static Word splitEnglishWord(Element ele) {
            String word = ele.getElementsByTag("span").first().text();
            String type = ele.getElementsByTag("span").get(1)
                    .text();
            String meaning = ele.getElementsByTag("div").first().text();
            Word newWord = new Word()
                    .withWord(word)
                    .withType(type)
                    .withMeaning(meaning);
            System.out.println(newWord);
            return newWord;
    }
    public static Word splitOtherWord(Element ele) {
        String word = ele.getElementsByTag("span").first().text();
        String meaning = ele.getElementsByTag("span").get(1)
                .text();
        Word newWord = new Word()
                .withWord(word)
                .withMeaning(meaning);
        System.out.println(newWord);
        return newWord;
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
