package com.ee.excellentpdf.web;

import com.ee.excellentpdf.domain.SalarySlip;
import com.ee.excellentpdf.reader.ExcelService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Controller
public class HomeController {

    private ExcelService excelService;

    @Autowired
    public HomeController(ExcelService excelService){
        this.excelService = excelService;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody
    String convertToPDf(@RequestPart("file") MultipartFile excelFile) throws IOException {
        File file = new File(excelFile.getName());
        excelFile.transferTo(file);
        final List<SalarySlip> salarySlips = excelService.fetchSalarySlips(file);

        return salarySlips.toString();
    }
}
