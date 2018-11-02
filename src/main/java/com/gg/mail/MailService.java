package com.gg.mail;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
