package com.xcclass.docker.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/docker")
    public String index(){
        return "index";
    }
}
