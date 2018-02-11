package com.manbot.command

/**
 * @author Pavan C. (pavan407)
 */
interface CommandParser
{
    fun isCommandCandidate(input: String): Boolean

    fun parseCommand(input: String): Command
}
