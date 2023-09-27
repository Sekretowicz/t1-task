package com.sekretowicz.t1task.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountCharsService {

    public Map<Character, Integer> countChars(String str) {
        Map<Character, Integer> map = new HashMap<>();

        //Посчитаем каждый символ и занесем в HashMap
        for (char c: str.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }

        //Упорядочим и сразу вернем
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
