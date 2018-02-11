package com.manbot.command

import com.manbot.event.Event
import com.manbot.command.Command

import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

/**
 * @author Pavan C. (pavan407)
 */
class CommandEvent(
        val command: Command,
        val user: User,
        val channel: MessageChannel
) : Event
