package com.manbot.command

import java.util.ArrayList
import java.util.regex.Pattern

/**
 * @author Nirodha
 */
class CommandParserImpl : CommandParser
{
    private val pattern = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'")

    /**
     *
     * @param input must have at least one non-whitespace character
     * @return determines whether or not the lead character of the input is a '!' character or not
     */
    override fun isCommandCandidate(input: String) = input.startsWith("!")

    /**
     *
     * @param input should come in the form !<input></input> to be a valid command. If non-! characters are first, the isCommandCandidate method won't recognize the input as a command.
     * @return
     */
    override fun parseCommand(input: String): Command
    {
        val tokenizedMessage = ArrayList<String>()
        val regexMatcher = pattern.matcher(input)

        while (regexMatcher.find())
            // DQ_TOKEN
            if (regexMatcher.group(1) != null)
                tokenizedMessage.add(regexMatcher.group(1))
            // SQ_TOKEN
            else if (regexMatcher.group(2) != null)
                tokenizedMessage.add(regexMatcher.group(2))
            // SIMPLE_TOKEN
            else
                tokenizedMessage.add(regexMatcher.group())

        val name = tokenizedMessage[0]
        tokenizedMessage.removeAt(0)

        return Command(name, tokenizedMessage)
    }
}
