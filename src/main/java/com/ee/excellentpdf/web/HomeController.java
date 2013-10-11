package com.ee.excellentpdf.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@Controller
public class HomeController {

  @RequestMapping("/")
    public String goHome() throws IOException {
      return "home";
  }

    @RequestMapping("/upload")
    public String convertToPDf(MultipartFile file){
        return "home";
    }
}
