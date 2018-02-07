package com.manbot.controller;

import com.manbot.Manbot;
import com.manbot.model.command.Command;
import net.dv8tion.jda.core.entities.User;

public interface CommandHandler
{
    boolean handle(Command cmd);

    String getName();
}
