package com.example.apilanguage.model;

public class Word {
    String word;
    String meaning;
    String type;

    public Word() {
    }
    public Word withWord(String word) {
        setWord(word);
        return this;
    }
    public Word withType(String type) {
        setType(type);
        return this;
    }
    public Word withMeaning(String meaning) {
        setMeaning(meaning);
        return this;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", type='" + type + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    public String json() {
        return "\"word\":\""+word+"\","+
                "\"meaning\":\""+word+"\"";
    }
}
