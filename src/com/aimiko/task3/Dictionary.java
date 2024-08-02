package com.aimiko.task3;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private final Map<String, List<String>> dictionary;
    private final Map<String, Integer> wordUsageCounter;

    public Dictionary() {
        this.dictionary = new HashMap<>();
        this.wordUsageCounter = new HashMap<>();
    }

    public void addWord(String word, List<String> translations) {
        dictionary.put(word, new ArrayList<>(translations));
        wordUsageCounter.put(word, 0);
    }

    public void replaceWord(String oldWord, String newWord) {
        if(dictionary.containsKey(oldWord)) {
            List<String> tranlations = dictionary.remove(oldWord);
            dictionary.put(newWord, tranlations);
            int count = wordUsageCounter.remove(oldWord);
            wordUsageCounter.put(newWord, count);
        } else out.println("Слово не знайдено у словнику.");
    }

    public void removeWord(String word) {
        dictionary.remove(word);
        wordUsageCounter.remove(word);
    }

    public void addTranslation(String word, String translation) {
        if(dictionary.containsKey(word)) dictionary.get(word).add(translation);
        else out.println("Слово не знайдено у словнику.");
    }

    public void replaceTranslations(String word, String oldTranslation, String newTranslation) {
        if (dictionary.containsKey(word)) {
            List<String> translations = dictionary.get(word);
            int index = translations.indexOf(oldTranslation);
            if (index != -1) {
                translations.set(index, newTranslation);
            } else {
                out.println("Переклад '" + oldTranslation + "' не знайдено для слова '" + word + "'.");
            }
        } else {
            out.println("Слово '" + word + "' не знайдено у словнику.");
        }
    }

    public void removeTranslation(String word, String translation) {
        if(dictionary.containsKey(word)) dictionary.get(word).remove(translation);
        else out.println("Слово не знайдено у словнику.");
    }

    public List<String> getTranslations(String word) {
        if(dictionary.containsKey(word)) {
            wordUsageCounter.put(word, wordUsageCounter.get(word) + 1);
            return dictionary.get(word);
        } else {
            out.println("Слово не знайдено у словнику.");
            return Collections.emptyList();
        }
    }

    public void displayTop10PopularWords() {
        wordUsageCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> out.println(entry.getKey() + " : " + entry.getValue() + " запити"));
    }

    public void displayTop10UnpopularWords() {
        wordUsageCounter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .forEach(entry -> out.println(entry.getKey() + " : " + entry.getValue() + " запити"));
    }
}
