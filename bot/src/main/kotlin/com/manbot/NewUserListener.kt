package com.manbot

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

/**
 * @author Pavan C. (pavan407)
 */
class NewUserListener : ListenerAdapter()
{
    override fun onGuildMemberJoin(event: GuildMemberJoinEvent)
    {
        event.guild.getTextChannelById(403187432159313923L).sendMessage("Please welcome " +
                event.user.asMention + " to the guild!").queue()
    }
}
