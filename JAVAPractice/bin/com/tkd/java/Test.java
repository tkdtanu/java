package com.example.demo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String input = "Programming";
        char ch[] = input.toCharArray();
        Stream.of()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterIntegerEntry -> {
                    return characterIntegerEntry.getValue() > 1;
                })
                .forEach(characterIntegerEntry -> {
                    System.out.println(characterIntegerEntry.getKey() + ":" + characterIntegerEntry.getValue());
                });


        /*Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char c : ch) {
            if (characterCountMap.containsKey(c)) {
                characterCountMap.put(c, characterCountMap.get(c) + 1);
            } else {
                characterCountMap.put(c, 1);
            }
        }
        characterCountMap.entrySet().stream().filter(characterIntegerEntry -> {
            return characterIntegerEntry.getValue() > 1;
        }).forEach(characterIntegerEntry -> {
            System.out.println(characterIntegerEntry.getKey() + ":" + characterIntegerEntry.getValue());
        });*/
    }
}
