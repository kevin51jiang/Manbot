package com.manbot.model.poll;

import com.manbot.Manbot;
import com.manbot.event.EventSubscriber;
import com.manbot.task.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Pavan C. (pavan407)
 */
public class PollService extends Service implements EventSubscriber<PollMutationEvent>
{
    public PollService()
    {
        super(0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onInit()
    {
        super.onInit();
        Manbot.getEventProvider().provideSubscriber(this);
    }

    @Override
    public void run()
    {
        PollManager.getAll().forEach(poll -> poll.tick(Duration.ofSeconds(1)));
    }

    @Override
    public void subscribe(PollMutationEvent event)
    {
        if (event.hasEnded())
        {
            event.getPoll().getChannel().sendMessage(
                    "Poll \"" + event.getPoll().getName() + "\" has ended.\n"
                            + "Here's a tally of the votes:\n\t" + event.getResults());
            event.getPoll().getChannel().sendMessage("Looks like \"" + event.getResults().getMostVotedChoice()
                    + " had the most votes.").queue();
        } else
        {
            if (event.getDuration().getSeconds() > 120
                    && event.getRemainingDuration().getSeconds() == event.getDuration().getSeconds() / 2)
                event.getPoll().getChannel().sendMessage(
                        "Poll \"" + event.getPoll().getName() + "\"" + " is halfway done.\n"
                                + "Only " + event.getRemainingDuration().getSeconds() + " seconds left!").queue();
            if (event.getRemainingDuration().getSeconds() == 30)
                event.getPoll().getChannel().sendMessage(
                        "Poll \"" + event.getPoll().getName() + "\"" + " only has 30 seconds left.\n"
                                + "Submit your votes ASAP if you haven't already!").queue();
        }
    }
}
