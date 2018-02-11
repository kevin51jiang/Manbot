package com.manbot.model.project;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * @author Pavan C. (pavan407)
 */
public final class ProjectManager
{
    private static Multimap<String, Project> projects = ArrayListMultimap.create();

    private ProjectManager() {}

    public static Collection<Project> getAll()
    {
        return projects.values();
    }

    public static void add(Project project)
    {
        projects.put(project.getName(), project);
    }
}
