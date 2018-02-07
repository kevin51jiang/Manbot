package com.manbot.controller.impl;

import com.manbot.controller.CommandHandler;
import com.manbot.model.command.Command;

public class HelpCommandHandler implements CommandHandler
{
    @Override
    public boolean handle(Command cmd)
    {
        cmd.channel.sendMessage("I can't help you right now.");
        return true;
    }

    @Override
    public String getName()
    {
        return "help";
    }
}
