package com.manbot.task

import com.manbot.Manbot
import com.manbot.plugin.Plugin

/**
 * @author Pavan C. (pavan407)
 */
abstract class Task : Runnable, Plugin
{
    override fun onInit()
    {
        Manbot.submitTask(this)
    }
}