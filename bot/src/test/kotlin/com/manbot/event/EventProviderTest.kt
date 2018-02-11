package com.manbot.event

import org.junit.Test

/**
 * @author Pavan C. (pavan407)
 */
class EventProviderTest : SuperEventProvider()
{
    private val provider: EventProvider<Event> = UniversalEventProvider()

    @Test
    fun pulseEvent()
    {
        provider.provideSubscriber(this)
        provider.pulseEvent(TestEvent())

        provider.getSubscribers(TestEvent::class)?.forEach { sub -> println(sub.javaClass.simpleName) }
    }
}