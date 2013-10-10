package com.ee.excellentpdf.email;

import java.io.File;

public interface EmailService  {
    public boolean sendMail(File attachment,String emailId,String subject,String body);
}


