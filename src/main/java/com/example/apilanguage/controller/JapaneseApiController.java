package com.example.apilanguage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class JapaneseApiController {
    @GetMapping("/api/furigana/{query}")
    public ObjectNode findFurigana(@PathVariable String query) throws IOException {

        Connection.Response response2 = Jsoup.connect("https://nihongodera.com/tools/furigana-maker")
                .method(Connection.Method.GET)
                .execute();
        Document responseDocument = response2.parse();
        // Get form element
        Element potentialForm = responseDocument.select("form.tool__form").first();
        FormElement form = (FormElement) potentialForm;
        // Fill textarea
        Elements txtArea = responseDocument.select("#toolInput");
        txtArea.get(0).text(query);
        // Redirect result
        Document resdoc = form.submit().post();
        Element res = resdoc.getElementsByClass("tool__results").get(0);
        // Get Analyze
        Element analyzeFormElement = resdoc.select("form.tool__inline-form").get(2);
        FormElement analyzeForm = (FormElement) analyzeFormElement;
        Document analyzeDoc = analyzeForm.submit().post();
        System.out.println(analyzeDoc.toString());
        Element resultAnalyze = analyzeDoc.getElementsByClass("entry-tile__partition tool__analyzer-bottom").first();
        System.out.println(resultAnalyze.toString());
        //Get data from service layer into entityList.
        res.toString();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        // JSON wrapper
        node.put("furigana", res.toString());
        node.put("analyze", resultAnalyze.toString());

        return node;
    }
}
