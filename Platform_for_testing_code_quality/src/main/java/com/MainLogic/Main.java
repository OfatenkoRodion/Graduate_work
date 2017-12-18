package com.MainLogic;


import com.MainLogic.dao.SenderSsl;
import com.MainLogic.dao.SenderTls;

public class Main
{
    private static SenderTls tlsSender = new SenderTls("justmadnessyo@gmail.com", "");
    private static SenderSsl sslSender = new SenderSsl("justmadnessyo@gmail.com", "");

    public static void main(String[] args)
    {
        tlsSender.send("This is Subject", "TLS: This is text!", "madnessjustyo@gmail.com", "madnessjust4@gmail.com");
        sslSender.send("This is Subject", "SSL: This is text!", "madnessjustyo@gmail.com", "madnessjust4@gmail.com");
        System.out.print("Done");
    }
}
