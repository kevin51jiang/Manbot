package com.manbot.command

import com.manbot.Manbot
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

/**
 * @author Pavan C. (pavan407)
 */
class CommandListener(private val parser: CommandParser) : ListenerAdapter()
{
    override fun onMessageReceived(event: MessageReceivedEvent)
    {
        val msg = event.message
        val ch = event.channel
        val user = event.author
        val input = msg.contentDisplay
        if (!parser.isCommandCandidate(input))
            return

        val cmd = parser.parseCommand(input)
        Manbot.pulseEvent(CommandEvent(cmd, user, ch))
    }
}
