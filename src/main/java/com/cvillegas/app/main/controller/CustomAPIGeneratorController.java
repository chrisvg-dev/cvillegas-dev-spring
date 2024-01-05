package com.cvillegas.app.main.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
@RequiredArgsConstructor
public class CustomAPIGeneratorController {

    @GetMapping("/info/apiGenerator/{items}")
    public List<Object> data(@PathVariable("items") String items) {
        Lorem lorem = LoremIpsum.getInstance();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JsonObject object = new JsonObject();
            for(String item: items.split(",")){
                object.addProperty(item, lorem.getWords(3, 5));
            }
            list.add(object);
        }
        return list;
    }

}
