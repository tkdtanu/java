package com.example.demo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LexicographicalSortedStrings implements Serializable {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","app");
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isSortedLexicographically(words, order));

        words = Arrays.asList("hello","leetcode");
        order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isSortedLexicographically(words, order));

        words = Arrays.asList("word","world","row");
        order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isSortedLexicographically(words, order));


    }

    public static boolean isSortedLexicographically(List<String> words, String order) {
        int totalWords = words.size();

        int maxCharacterWordSize = getMaxCharacterWordSize(words);

        List<char[]> wordCharacterList = getWordCharacterList(words);

        Map<Character, Integer> characterOrderMap = getCharacterOrderMap(order);

        for (int i = 0; i < words.size() - 1; i++) {
            char[] firstWord = wordCharacterList.get(i);
            char[] secondWord = wordCharacterList.get(i + 1);
            int length = firstWord.length > secondWord.length ? firstWord.length : secondWord.length;
            for (int j = 0; j < length; j++) {
                if(j>=firstWord.length){
                    break;
                }
                if(j>=secondWord.length){
                    return false;
                }
                if(characterOrderMap.get(secondWord[j])>characterOrderMap.get(firstWord[j])){
                    return true;
                }
                if(characterOrderMap.get(secondWord[j])<characterOrderMap.get(firstWord[j])){
                    return false;
                }
            }

        }
        return true;
    }

    private static List<char[]> getWordCharacterList(List<String> words) {
        return words.stream().map(w -> w.toCharArray())
                .collect(Collectors.toList());
    }

    private static int getMaxCharacterWordSize(List<String> words) {
        int result = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > result) {
                result = words.get(i).length();
            }
        }

        return result;
    }

    private static Map<Character, Integer> getCharacterOrderMap(String order) {
        char[] ch = order.toCharArray();
        Map<Character, Integer> characterOrderMap = new HashMap<>();

        for (int i = 0; i < ch.length; i++) {
            characterOrderMap.put(ch[i], i);
        }

        return characterOrderMap;
    }
}
