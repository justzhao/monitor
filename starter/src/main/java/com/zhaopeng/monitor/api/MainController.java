package com.zhaopeng.monitor.api;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @Cacheable(value = "people", key = "#id")
    @RequestMapping("/api/index")
    public @ResponseBody
    Object index(int id) {

        return new Long[100000];
    }
}
