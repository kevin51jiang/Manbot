package com.manbot.model.poll;

import com.manbot.event.Event;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

/**
 * @author Pavan C. (pavan407)
 */
public class PollMutationEvent implements Event
{
    private final Poll poll;
    private final Duration tick;

    public PollMutationEvent(Poll poll, Duration tick)
    {
        this.poll = poll;
        this.tick = tick;
    }

    public Poll getPoll()
    {
        return poll;
    }

    public Duration getTick()
    {
        return tick;
    }

    public Duration getDuration()
    {
        return getPoll().getDuration();
    }

    public Duration getRemainingDuration()
    {
        return getPoll().getRemainingDuration();
    }

    public boolean hasEnded()
    {
        return getPoll().hasEnded();
    }

    public PollResults getResults()
    {
        return getPoll().getResults();
    }
}
