package com.project.resumeanalyzer.nlp;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ResumeAnalyzer {

    private static final Set<String> stopWords = new HashSet<>(Arrays.asList(
            "and", "or", "the", "a", "an", "with", "in", "of", "to"
    ));

    public static Set<String> extractKeywords(String resumeText) {
        if (resumeText == null) {
            return Set.of();
        }
        return Arrays.stream(resumeText.toLowerCase().split("\\W+"))
                .filter(word -> !stopWords.contains(word) && word.length() > 2)
                .collect(Collectors.toSet());
    }
}
