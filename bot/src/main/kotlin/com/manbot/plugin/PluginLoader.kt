package com.manbot.plugin

/**
 * @author Pavan C (pavan407)
 */
interface PluginLoader
{
    fun load(): Collection<Plugin>
}
