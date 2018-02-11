package com.manbot.model.poll;

import com.manbot.event.EventSubscriber;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.util.*;

/**
 * @author Pavan C. (pavan407)
 */
public final class PollManager implements EventSubscriber<PollMutationEvent>
{
    private static Map<MessageChannel, Map<String, Poll>> polls = new HashMap<>();

    public static void submit(Poll poll)
    {
        polls.computeIfAbsent(poll.getChannel(), ch -> new HashMap<>());
        polls.get(poll.getChannel()).putIfAbsent(poll.getName(), poll);
    }

    @Override
    public void subscribe(PollMutationEvent event)
    {
        if (event.hasEnded())
            polls.remove(event.getPoll().getChannel(), event.getPoll().getName());
    }

    public static Poll get(MessageChannel ch, String name)
    {
        return polls.get(ch).get(name);
    }

    public static Collection<Poll> getAll()
    {
        Set<Poll> allPolls = new HashSet<>();
        polls.values().forEach(chPolls -> allPolls.addAll(chPolls.values()));
        return allPolls;
    }
}
