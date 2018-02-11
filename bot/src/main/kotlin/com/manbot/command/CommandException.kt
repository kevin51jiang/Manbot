package com.manbot.command

import com.manbot.user.MessageFormattedException

/**
 * @author Pavan C. (pavan407)
 */
class CommandException(val userFormattedMesssage: String) : MessageFormattedException()
