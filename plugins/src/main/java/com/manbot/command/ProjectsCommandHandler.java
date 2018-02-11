package com.manbot.command;

import com.manbot.model.project.ProjectManager;

/**
 * @author Pavan C. (pavan407)
 */
public class ProjectsCommandHandler extends CommandHandler
{
    public ProjectsCommandHandler()
    {
        super("projects", "Prints list of all the currently active projects.");
    }

    @Override
    public void handle(CommandEvent event) throws CommandException
    {
        StringBuilder projects = new StringBuilder();
        ProjectManager.getAll().forEach(project -> projects.append("\n").append(project.getName()).append(":\t")
                .append(project.getDescription()));
        event.getChannel().sendMessage("Hey " + event.getUser().getAsMention()
                + ", here's a list of all the currently active projects:\n" + projects.toString()).queue();
    }
}