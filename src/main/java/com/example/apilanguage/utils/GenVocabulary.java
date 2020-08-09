package com.example.apilanguage.utils;

import com.example.apilanguage.model.DanhNgon;
import com.example.apilanguage.model.Word;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.apilanguage.utils.Utils.splitChamNgon;
import static com.example.apilanguage.utils.Utils.splitWord;

public class GenVocabulary {
    public GenVocabulary(String chinese, int num) {
    }

    public static ArrayList<Word> genVocabulary(String language, int num) throws IOException {
        String link = "";
        if (language.compareTo("english")==0) {
            link = "https://www.bestrandoms.com/random-words";
        }
        else {
            link = "https://www.bestrandoms.com/random-" + language + "-words";
        }
        System.out.println(link);
        Connection.Response response2 = Jsoup.connect(link)
                .method(Connection.Method.GET)
                .execute();
        Document responseDocument = response2.parse();
        System.out.println(responseDocument);

        // Change num of words
        Element numWord = responseDocument.getElementsByClass("form-control").get(0);
        numWord.attr("value", String.valueOf(num));
        System.out.println(numWord);

        // Submit form and gen words;
        Element submitForm = responseDocument.getElementsByClass("form-horizontal").get(0);
        FormElement form = (FormElement) submitForm;
        Document newDoc = form.submit().post();
        System.out.println(newDoc);
        Elements list = newDoc.getElementsByClass("col-xs-12 col-sm-6");
        System.out.println(list);
        ArrayList<Word> arrayList = new ArrayList<>();
        for (Element ele: list
        ) {
            Word word = splitWord(ele.toString());
            arrayList.add(word);
        }
        return arrayList;
    }

    public static ObjectNode genVocabularyBot(ArrayList<Word> list) throws IOException {

        // Add word to your list and json them
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode parentnode = mapper.createObjectNode();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Word word: list
        ) {
            ObjectNode childnode = mapper.createObjectNode();
            String s = word.getWord()+": "+word.getMeaning();
            childnode.put("text", s);
            arrayNode.add(childnode);
        }
//
//        // JSON wrapper
        parentnode.put("messages", arrayNode);
        return parentnode;
    }
    public static ArrayList<DanhNgon> getDanhNgon() throws IOException {
        Connection.Response response2 = Jsoup.connect("https://www.tudiendanhngon.vn/")
                .method(Connection.Method.GET)
                .execute();
        Document responseDocument = response2.parse();
        Elements eles = responseDocument.getElementsByClass("DnnModule-KKCMSSystemRandomQuote");
        System.out.println(eles.size());

        ArrayList<DanhNgon> list = new ArrayList<>();
        for (Element ele: eles
        ) {
            list.add(splitChamNgon(ele));
        }

        return list;
    }

    public static ObjectNode getDanhNgonBot(ArrayList<DanhNgon> list) throws IOException {
        // Add word to your list and json them
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode parentnode = mapper.createObjectNode();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (DanhNgon danhNgon: list
        ) {
            ObjectNode childnode = mapper.createObjectNode();
            String s = danhNgon.getTheLoai()+":\n"+danhNgon.getCauViet()+"----"+danhNgon.getTacGia()+"----";
            childnode.put("text", s);
            arrayNode.add(childnode);
        }

        // JSON wrapper
        parentnode.put("messages", arrayNode);
        return parentnode;
    }
}
