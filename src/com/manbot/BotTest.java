package com.manbot;

import com.manbot.controller.CommandListener;
import com.manbot.service.impl.AnnouncementService;

public class BotTest
{
    public static void main(String[] args) throws Exception
    {
        Manbot bot = new Manbot(args[0]);
        //bot.scheduleService(new AnnouncementService());
        bot.jda.addEventListener(new CommandListener());
    }
}
