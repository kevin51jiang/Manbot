package com.manbot.command;

import com.manbot.user.UserType;

/**
 * @author Pavan C. (pavan407)
 */
public class JavaCommandHandler extends CommandHandler
{
    public JavaCommandHandler()
    {
        super("java", "Greets you!", ArgumentAmount.anyLength(), UserType.LEARNER, "[your name]");
    }

    @Override
    public void handle(CommandEvent event) throws CommandException
    {
        event.getChannel().sendMessage("Hello from Java " + event.getUser().getAsMention() + "!").queue();
    }
}
