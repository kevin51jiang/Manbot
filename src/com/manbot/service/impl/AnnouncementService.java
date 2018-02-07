package com.manbot.service.impl;

import com.manbot.service.Service;

/**
 * Proof of concept
 */
public class AnnouncementService extends Service
{
    private String[] announcements = {
            "Remember to ask for help when you need it!",
            "If you need help using the bot, type !help."
    };

    public AnnouncementService()
    {
        super(0, 30);
    }

    @Override
    public void run()
    {}

}
