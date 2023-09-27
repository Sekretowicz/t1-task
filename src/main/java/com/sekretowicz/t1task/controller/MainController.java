package com.sekretowicz.t1task.controller;

import com.sekretowicz.t1task.service.CountCharsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private CountCharsService countCharsService;

    @PostMapping("/count-chars")
    public Map<Character, Integer> countChars (@RequestBody String str) {
        return countCharsService.countChars(str);
    }
}
