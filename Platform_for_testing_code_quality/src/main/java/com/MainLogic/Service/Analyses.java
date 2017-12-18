package com.MainLogic.Service;

import com.MainLogic.dao.DownloadFile;
import com.MainLogic.dao.Order;

import java.io.IOException;

public class Analyses
{
    // Send the user a confirmation of the start of work
    // Unloads the file for analysis
    public static void start (final Order orderOnAnalysis )
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                SenderImpl sslSender = new SenderSsl("justmadnessyo@gmail.com", "No");
                sslSender.send("Анализ кода", "Спасибо! Ваша заявка принята на обработку.", "madnessjustyo@gmail.com", orderOnAnalysis.getGmail());

                /// Вызываем штуки для метрик

                try
                {
                    DownloadFile.start(orderOnAnalysis.getGitFilePath(),"F:\\");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
