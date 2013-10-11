package com.ee.excellentpdf.email;

import org.springframework.stereotype.Service;

import java.io.File;
@Service
public interface EmailService  {
    public boolean sendMail(File attachment,String emailId,String subject,String body);
}


