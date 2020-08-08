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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {


    @GetMapping("/")
    public String greet() throws IOException {
        return "Welcome Language API!";
    }

    @GetMapping("/api/{language}/{num}")
    public ObjectNode generateWord(@PathVariable String language, @PathVariable String num) throws IOException {
        System.out.println(num);
        return GenVocabulary.genVocabulary(language, Integer.parseInt(num));
    }

    private ResponseEntity<String> sendBackResponse(String jsonString, HttpStatus status) {
        ResponseEntity<String> respEntity = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-disposition", "inline; filename=api-result.json");
        responseHeaders.add("Content-Type", "application/json; charset=utf-8");
        respEntity = new ResponseEntity<>(jsonString, responseHeaders, status);
        return respEntity;
    }
}
