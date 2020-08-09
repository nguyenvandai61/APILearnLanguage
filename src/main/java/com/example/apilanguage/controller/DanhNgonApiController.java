package com.example.apilanguage.controller;

import com.example.apilanguage.utils.GenVocabulary;
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
public class DanhNgonApiController {
    @GetMapping("/api/bdanhngon/")
    public ObjectNode danhNgonBot() throws IOException {
        return GenVocabulary.getDanhNgonBot(GenVocabulary.getDanhNgon());
    }
}
