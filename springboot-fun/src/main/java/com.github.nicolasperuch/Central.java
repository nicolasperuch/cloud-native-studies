package com.github.nicolasperuch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Central {


    @RequestMapping("/producelog/{log}")
    @ResponseBody
    public boolean produceLog(){
        return true;
    }

}
