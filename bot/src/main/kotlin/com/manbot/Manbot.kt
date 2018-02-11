package com.manbot

import com.manbot.command.CommandListener
import com.manbot.command.CommandParserImpl
import com.manbot.event.Event
import com.manbot.event.EventProvider
import com.manbot.event.UniversalEventProvider
import com.manbot.plugin.LocalPluginLoader
import com.manbot.plugin.PluginLoadTask
import com.manbot.task.Service
import com.manbot.task.Task
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.hooks.EventListener
import java.nio.file.Paths
import java.util.concurrent.Future
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author Pavan C. (pavan407)
 */
object Manbot
{
    @JvmStatic
    val jda: JDA = JDABuilder(AccountType.BOT).setToken(System.getenv("MANBOT_TOKEN")).buildBlocking()

    @JvmStatic
    val eventProvider: EventProvider<Event> = UniversalEventProvider()

    private val serviceExecutor = ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors())

    @JvmStatic
    fun main(vararg args: String)
    {
        // Init listeners
        registerListeners(NewUserListener(), CommandListener(CommandParserImpl()))

        // Load plugins
        submitTask(PluginLoadTask(LocalPluginLoader(
                // TODO Get plugin dir from config
                Paths.get("${System.getProperty(("user.dir"))}/../plugins/build/classes/java/main")))).get()

        println("Manbot ready!")
    }

    @JvmStatic
    fun registerListeners(vararg listeners: EventListener)
    {
        jda.addEventListener(*listeners)
    }

    @JvmStatic
    fun <E : Event> pulseEvent(event: E) = eventProvider.pulseEvent(event)

    @JvmStatic
    fun submitTask(task: Task): Future<*>
    {
        return serviceExecutor.submit(task)
    }

    @JvmStatic
    fun scheduleService(service: Service): ScheduledFuture<*>
    {
        return serviceExecutor.scheduleWithFixedDelay(service,
                service.initialDelay,
                service.intervalDelay,
                service.timeUnit)
    }

    @JvmStatic
    fun removeService(service: Service)
    {
        serviceExecutor.remove(service)
    }

    @JvmStatic
    fun shutdown()
    {
        try
        {
            serviceExecutor.awaitTermination(30, TimeUnit.SECONDS)
        } catch (e: Exception)
        {
            e.printStackTrace()
        } finally
        {
            jda.shutdown()
        }
    }
}