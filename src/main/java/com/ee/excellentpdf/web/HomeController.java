package com.ee.excellentpdf.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class HomeController {

  @RequestMapping("/home")
    public String goHome(){
      return "redirect:home";
  }
}
