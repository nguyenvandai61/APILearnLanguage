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
public class ChineseApiController {
    @GetMapping("/api/pinyin/{query}")
    public ObjectNode findPinyin(@PathVariable String query) throws IOException {

        Connection.Response response2 = Jsoup.connect("https://www.mdbg.net/chinese/dictionary")
                .method(Connection.Method.GET)
                .execute();
        Document responseDocument = response2.parse();
        // Get form element
        Element potentialForm = responseDocument.select("form#form_wdqt").first();
        FormElement form = (FormElement) potentialForm;

        // Fill textarea
        Elements txtArea = responseDocument.select("#txa_text");
        txtArea.get(0).text(query);
        // Redirect result
        Document resdoc = form.submit().post();
        Element res = resdoc.getElementById("tta_output_ta");
//
//        // Get Analyze
        Element analyzeFormElement = resdoc.select("td.resultswrap").first();
        // JSON wrapper
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("analyze", analyzeFormElement.toString());
        return node;
    }
}
