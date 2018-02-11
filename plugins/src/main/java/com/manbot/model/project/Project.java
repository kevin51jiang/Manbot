package com.manbot.model.project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavan C. (pavan407)
 */
public class Project
{
    private final String name;
    private final String description;
    private List<String> maintainers = new ArrayList<>();
    private List<String> contributors = new ArrayList<>();

    public Project(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}
