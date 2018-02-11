package com.manbot.plugin

import com.manbot.task.Task

/**
 * @author Pavan C. (pavan407)
 */
class PluginLoadTask(private vararg val loaders: PluginLoader) : Task()
{
    override fun run()
    {
        val plugins = mutableSetOf<Plugin>()
        loaders.forEach { loader -> plugins.addAll(loader.load()) }
        plugins.forEach { plugin -> plugin.onInit() }
    }
}