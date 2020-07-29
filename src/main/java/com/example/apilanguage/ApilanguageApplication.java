package com.example.apilanguage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ApilanguageApplication {
    private static String getContentFrom(String link) throws IOException {
        // Gởi HTTP request và nhận về kết quả là chuỗi các thẻ HTML
        URL url = new URL(link);
        URLConnection uc;

        uc = url.openConnection();
        uc.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        Scanner scanner = new Scanner(new InputStreamReader(uc.getInputStream()));
        scanner.useDelimiter("\\\\Z");
        String content = scanner.next();
        scanner.close();
        // xoá các ký tự ngắt dòng (xuống dòng)
        content = content.replaceAll("\\\\R", "");
        return content;
    }
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ApilanguageApplication.class, args);

//
//        String query = "彼らは自由のために戦った。";
//        Connection.Response response2 = Jsoup.connect("https://nihongodera.com/tools/furigana-maker")
//                .method(Connection.Method.GET)
//                .execute();
//        Document responseDocument = response2.parse();
//        // Get form element
//        Element potentialForm = responseDocument.select("form.tool__form").first();
//        FormElement form = (FormElement) potentialForm;
//        // Fill textarea
//        Elements txtArea = responseDocument.select("#toolInput");
//        txtArea.get(0).text(query);
//        // Redirect result
//        Document resdoc = form.submit().post();
////        System.out.println(resdoc);
////        System.out.println(resdoc.getElementsByClass("tool__results").get(0));
//        Element analyzeFormElement = resdoc.select("form.tool__inline-form").get(2);
//        FormElement analyzeForm = (FormElement) analyzeFormElement;
//        Document analyzeDoc = analyzeForm.submit().post();
//        System.out.println(analyzeDoc.toString());
//        Element resultAnalyze = analyzeDoc.getElementsByClass("entry-tile__partition tool__analyzer-bottom").first();
//        System.out.println(resultAnalyze.toString());
    }

}
