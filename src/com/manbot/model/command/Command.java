package com.manbot.model.command;

import com.manbot.Manbot;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.List;

public class Command
{
    public final JDA jda;
    public final User sender;
    public final MessageChannel channel;
    public final String name;
    public final List<String> args; // TODO Make this immutable

    public Command(JDA jda, User sender, MessageChannel channel, String name, List<String> args)
    {
        this.jda = jda;
        this.sender = sender;
        this.channel = channel;
        this.name = name;
        this.args = args;
    }
}
