package com.xcclass.nginx_2019.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
  //  @Value("${server.port}")
   // private String port;
    @RequestMapping("/demo")
    public String index()  {
       // request.setAttribute("port",port);
        return "index";
    }
}
