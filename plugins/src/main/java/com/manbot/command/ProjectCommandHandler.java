package com.manbot.command;

import com.manbot.model.project.Project;
import com.manbot.model.project.ProjectManager;

/**
 * @author Pavan C. (pavan407)
 */
public class ProjectCommandHandler extends CommandHandler
{
    public ProjectCommandHandler()
    {
        super("project", "Project operations.", ArgumentAmount.greaterThan(1));
    }

    @Override
    public void handle(CommandEvent event) throws CommandException
    {
        Command cmd = event.getCommand();
        String op = cmd.getNextArgument();
        switch (op)
        {
            case "start":
            case "create":
            {
                String name = cmd.getNextArgument();
                String desc = cmd.getNextArgument();
                String lang = cmd.getNextArgument();

                ProjectManager.add(new Project(name, desc));
                event.getChannel().sendMessage("Hey " + event.getUser().getAsMention() + ", \"" + name
                        + "\" has been added to the list of active projects!").queue();
            }
        }
    }
}
