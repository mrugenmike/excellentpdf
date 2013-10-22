package com.ee.excellentpdf.email;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public interface EmailService  {
    public boolean sendMail(File attachment,String emailId,String subject,String body);
    public void sendEmailToAll(Map<String, String> files, String subject,String body);
}


