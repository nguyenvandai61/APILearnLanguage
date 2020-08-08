package com.example.apilanguage.controller;

import com.example.apilanguage.utils.GenVocabulary;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.Map;

@RestController
public class EnglishApiController {

    @GetMapping("/api/english/generatePhrase")
    public JsonNode generateEnglishPhrase() throws IOException {
        // Get Phrase
        Document responseDocument = Jsoup.connect("https://randomwordgenerator.com/json/phrases.json")
                .ignoreContentType(true).get();;

        String res = responseDocument.getElementsByTag("body").get(0).text();
            // JSON wrapper
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(res);

        return node;
    }
}
