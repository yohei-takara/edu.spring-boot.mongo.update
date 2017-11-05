package com.example.mongo.update.controller;

import com.example.mongo.update.configuration.MongoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("moto")
public class MotogpContoroller {


    @Autowired
    private MongoConfiguration mongoConfiguration;

    @RequestMapping("/all")
    @ResponseBody
    public String getMachine() {

        mongoConfiguration.getDb();

        return null;
    }
}
