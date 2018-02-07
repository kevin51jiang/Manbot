package com.manbot;

import com.manbot.service.Service;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.hooks.EventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Manbot
{

    public final JDA jda;

    private ScheduledExecutorService serviceExecutor = Executors.newScheduledThreadPool(4);

    public Manbot(String token) throws Exception
    {
        jda = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .buildBlocking();
    }

    public Manbot scheduleService(Service service)
    {
        serviceExecutor.scheduleWithFixedDelay(service, service.initialDelay, service.intervalDelay, service.timeUnit);
        return this;
    }
}
