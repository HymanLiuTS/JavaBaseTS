package com.example.a06printstackinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class A06printstackinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(A06printstackinfoApplication.class, args);
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView=new ModelAndView("hello");
        modelAndView.addObject("name","zhangsan");
        return modelAndView;
    }
}
