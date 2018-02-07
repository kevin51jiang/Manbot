package com.manbot.controller;

import com.manbot.controller.impl.HelpCommandHandler;
import com.manbot.model.command.Command;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.*;

public class CommandListener extends ListenerAdapter
{
    private Map<String, CommandHandler> handlers = new HashMap<>();

    public CommandListener()
    {
        initDefaults();
    }

    private void initDefaults()
    {
        handlers.put("help", new HelpCommandHandler());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        String cmd = msg.getContentDisplay();

        try
        {
            Command c = parseCommand(event.getJDA(), event.getAuthor(), event.getChannel(), cmd);
            handlers.get(c.name).handle(c);
        } catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
    }

    private Command parseCommand(JDA jda, User sender, MessageChannel channel, String cmd)
    {
        if (!cmd.startsWith("!"))
            throw new IllegalArgumentException();

        List<String> args = Arrays.asList(cmd.split(" "));
        String name = args.remove(0);

        return new Command(jda, sender, channel, name, args);
    }
}
