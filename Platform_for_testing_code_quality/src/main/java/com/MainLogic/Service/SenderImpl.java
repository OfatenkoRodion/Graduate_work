package com.MainLogic.Service;

public interface SenderImpl
{
    void send(String subject, String text, String fromEmail, String toEmail);
}
