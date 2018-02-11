package com.manbot.command

import com.manbot.plugin.Plugin
import com.manbot.user.UserType

/**
 * @author Pavan C. (pavan407)
 */
abstract class CommandHandler @JvmOverloads constructor(
        val name: String,
        val description: String = "N/A",
        val argumentAmount: (Int) -> Boolean = ArgumentAmount.anyLength(),
        val requiredUserType: UserType = UserType.LEARNER,
        val usage: String = "N/A"
) : Plugin
{
    override fun onInit() = CommandHandlerCoordinator.applyCoordination(this)

    @Throws(CommandException::class)
    abstract fun handle(event: CommandEvent)
}