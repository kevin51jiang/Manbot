package com.manbot.command;

/**
 * @author Pavan C. (pavan407)
 */
public class HelpCommandHandler extends CommandHandler
{
    public HelpCommandHandler()
    {
        super("help");
    }

    @Override
    public void handle(CommandEvent event)
    {
        StringBuilder cmds = new StringBuilder();
        for (CommandHandler handler : CommandHandlerCoordinator.INSTANCE)
            if (handler != this)
                cmds.append("!").append((handler).getName()).append("\t").append((handler).getDescription()).append("\t")
                        .append(handler.getUsage()).append("\n");

        event.getChannel().sendMessage("Hey " + event.getUser().getAsMention()
                + ", here's a list of commands you can use with me\n" + cmds.toString()).queue();
    }
}
