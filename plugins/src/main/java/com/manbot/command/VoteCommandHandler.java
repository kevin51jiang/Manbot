package com.manbot.command;

import com.manbot.model.poll.PollManager;
import com.manbot.user.User;

/**
 * @author Pavan C. (pavan407)
 */
public class VoteCommandHandler extends CommandHandler
{
    public VoteCommandHandler()
    {
        super("vote", "Vote", ArgumentAmount.fixed(2));
    }

    @Override
    public void handle(CommandEvent event) throws CommandException
    {
        String name = event.getCommand().getNextArgument();
        String choice = event.getCommand().getNextArgument();

        PollManager.get(event.getChannel(), name).submitVote(new User(), choice);
        event.getChannel().sendMessage("Hey " + event.getUser().getAsMention()
                + ", your vote has been submitted!").queue();
    }
}
