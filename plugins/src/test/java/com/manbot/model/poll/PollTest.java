package com.manbot.model.poll;

import net.dv8tion.jda.core.entities.User;
//import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PollTest
{
    private ScheduledThreadPoolExecutor serviceExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());

    //@Test
    public void submitPoll()
    {
        Poll p = new Poll("test poll", null, Duration.ofSeconds(10), new HashSet<>(Arrays.asList("choice1", "choice2", "choice3")));
        PollManager.submit(p);
        serviceExecutor.scheduleWithFixedDelay(new PollService(), 0, 1, TimeUnit.SECONDS);

//        p.submitVote(new User(), "choice1");
//        p.submitVote(new User(), "choice1");
//        p.submitVote(new User(), "choice1");
//        p.submitVote(new User(), "choice1");
//
//        p.submitVote("choice2", new User());
//        p.submitVote("choice2", new User());
//
//        p.submitVote("choice3", new User());
//        p.submitVote("choice3", new User());
//        p.submitVote("choice3", new User());

        while (true)
        {
            try
            {
                Thread.sleep(1500);
            } catch(Exception e)
            {}
        }
    }
}
