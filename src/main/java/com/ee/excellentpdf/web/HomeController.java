package com.ee.excellentpdf.web;

import com.ee.excellentpdf.domain.RenderService;
import com.ee.excellentpdf.domain.SalarySlip;
import com.ee.excellentpdf.email.EmailService;
import com.ee.excellentpdf.reader.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@Controller
public class HomeController {

    private ExcelService excelService;
    private RenderService renderService;
    private EmailService emailService;

    @Autowired
    public HomeController(ExcelService excelService, RenderService renderService, EmailService emailService) {
        this.excelService = excelService;
        this.renderService = renderService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String convertToPDf(@RequestPart("file") MultipartFile excelFile) throws IOException {
        File file = new File(excelFile.getName());
        excelFile.transferTo(file);
        final List<SalarySlip> salarySlips = excelService.fetchSalarySlips(file);

        return salarySlips.toString();
    }

    @RequestMapping(value = "/email")
    public
    @ResponseBody
    String sendEmail() {
        final String emailId = "mdeshmukh@equalexperts.com";
        emailService.sendMail(new File("/home/mrugen/Downloads/sal.pdf"), emailId, "Salary For This Month", "Hi User hope you get paid!!!");
        return "sent email to " + emailId;
    }
}
